package com.neusoft.npms.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neusoft.npms.dto.ChanceQueryCondition;
import com.neusoft.npms.dto.RespBean;
import com.neusoft.npms.dto.ReturnChanceBasicInfo;
import com.neusoft.npms.entity.Chance;
import com.neusoft.npms.entity.ChanceDraft;
import com.neusoft.npms.entity.Dept;
import com.neusoft.npms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yky
 * @since 2021-07-13
 */
@CrossOrigin
@RestController
@RequestMapping("/npms/chance")
public class ChanceController {
    @Autowired
    IDeptService iDeptService;

    @Autowired
    IChanceService iChanceService;

    @Autowired
    IChanceDraftService iChanceDraftService;

    @Autowired
    IUserService iUserService;

    @Autowired
    IChanceStatusService iChanceStatusService;

    @Autowired
    IChanceSourceService iChanceSourceService;

    @Autowired
    IChanceStageService iChanceStageService;

    @Autowired
    IClientService iclientService;

    @Cacheable(cacheNames = "getDepartments")
    @GetMapping("/get_departments")
    public RespBean getDepartments(String user_id, String role_id){
        System.out.println("/get_departments: user_id:"+ user_id+" role_id:"+role_id);
        if (user_id == null || role_id == null)
            return RespBean.error(400,"参数为null");

        List<Dept> deptList = iDeptService.getDepartment(user_id, role_id);
        if (deptList == null || deptList.size() == 0)
            return RespBean.error(400, "no department found");
        return RespBean.ok(200,"departments", deptList);
    }

    @GetMapping("/get_chance_basic_info_by_client_id")
    public RespBean getChanceBasicInfoByClientId(String clientId){
        System.out.println("/get_chance_basic_info_by_client_id");
        System.out.println("clientId: "+ clientId);
        System.out.println();
        if (clientId == null || clientId.equals("")) return RespBean.error(400,"参数为空");

        List<Chance> result = iChanceService.list(Wrappers.<Chance>lambdaQuery().eq(Chance::getClientId,clientId));
        return RespBean.ok(200,"根据clientId获取他所有的chance",result);
    }

    // role 1 客户经理
    // role 3 销售总监
    @PostMapping("/query_chance_basic_info")
    public RespBean queryChanceBasicInfo(@RequestBody ChanceQueryCondition chanceQueryCondition){
        System.out.println("/query_chance_basic_info");
        System.out.println("chanceQueryCondition:"+chanceQueryCondition);
        System.out.println();

        if (chanceQueryCondition == null || chanceQueryCondition.getLoginUserId() == null
                || chanceQueryCondition.getLoginUserId().equals(""))
            return RespBean.error(400,"参数为空或缺少参数");
        // 获取role
        int role = iUserService.getById(chanceQueryCondition.getLoginUserId()).getRoleId();

        List<Chance> resultList = null;
        List<ChanceDraft> resultListDraft = null;
        List<ReturnChanceBasicInfo> returnList = new ArrayList<>();

        // 查本体表 不管是什么role 都需要查这张表
        if ((chanceQueryCondition.getChanceTypeNum()!=null && !chanceQueryCondition.getChanceTypeNum().equals(""))
                || (chanceQueryCondition.getProductNum() != null && !chanceQueryCondition.getProductNum().equals(""))){
            System.out.println("有参数");
            resultList = iChanceService.getChanceWithChanceTypeAndProductNum(chanceQueryCondition);
        } else {
            System.out.println("无参数");
            resultList = iChanceService.getChanceByCondition(chanceQueryCondition);
        }
        List<ReturnChanceBasicInfo> result = iChanceService.translate(resultList);

        // 1 3 能看见草稿表中的内容，其他人只看本体表中的内容
        if (role != 1 && role != 3) {
            return RespBean.ok(200,"根据搜索条件获取chance的list",result);
        } else {
            if ((chanceQueryCondition.getChanceTypeNum()!=null && !chanceQueryCondition.getChanceTypeNum().equals(""))
                    || (chanceQueryCondition.getProductNum() != null && !chanceQueryCondition.getProductNum().equals(""))){
                System.out.println("有参数+draft");
                resultListDraft = iChanceDraftService.getChanceWithChanceTypeAndProductNum(chanceQueryCondition);
            } else {
                System.out.println("无参数+draft");
                resultListDraft = iChanceDraftService.getChanceByCondition(chanceQueryCondition);
            }
            // 去重
            Set<String> set = new HashSet<>();
            for (ChanceDraft draft:resultListDraft) {
                returnList.add(new ReturnChanceBasicInfo(draft,iChanceSourceService,iChanceStageService,iDeptService,iUserService,iChanceStatusService));
                set.add(draft.getChanceNum());
            }

            for (Chance chance:resultList) {
                if (set.contains(chance.getChanceNum()))
                    continue;
                returnList.add(new ReturnChanceBasicInfo(chance,iChanceSourceService,iChanceStageService,iDeptService,iUserService,iChanceStatusService));
            }

            return RespBean.ok(200,"根据搜索条件获取chance + draft的list",returnList);
        }
    }

/*    @Autowired
    IChanceTypeProductService chanceTypeProductService;

    @PostMapping("/test")
    public RespBean test(@RequestBody ChanceQueryCondition chanceQueryCondition){
        return RespBean.ok(200,"k",chanceTypeProductService.getItemsByChanceAndProduct(chanceQueryCondition));
    }*/

    @GetMapping("/get_chance_basic_info_in_draft_and_real_by_chance_num")
    public RespBean getChanceBasicInfoInDraftAndRealByChanceNum(String chanceNum){
        System.out.println("/get_chance_basic_info_in_draft_and_real_by_chance_num");
        System.out.println("chanceNum: "+chanceNum);
        System.out.println();

        if (chanceNum == null || chanceNum.equals("")) return RespBean.error(400,"参数为空");

        // 查本体
        List<Chance> chanceList = iChanceService.list(Wrappers.<Chance>lambdaQuery().eq(Chance::getChanceNum,chanceNum));
        // 查draft
        List<ChanceDraft> chanceDraftList = iChanceDraftService.list(Wrappers.<ChanceDraft>lambdaQuery().eq(ChanceDraft::getChanceNum,chanceNum));
        if (chanceDraftList != null && chanceDraftList.size() != 0) {
            return RespBean.ok(200,"通过chanceNum在draft中查到basicInfo",new ReturnChanceBasicInfo(chanceDraftList.get(0),iChanceSourceService, iChanceStageService,
                    iDeptService, iUserService, iChanceStatusService));
        } else if (chanceList != null && chanceList.size() != 0) {
            return RespBean.ok(200,"通过chanceNum在本体中查到basicInfo",new ReturnChanceBasicInfo(chanceList.get(0),iChanceSourceService, iChanceStageService,
                    iDeptService, iUserService, iChanceStatusService));
        }
        return RespBean.ok(200,"没找到");
    }

    @PostMapping("/modify_chance_basic_info")
    public RespBean modifyChanceBasicInfo(@RequestBody Chance chance) {
        System.out.println("/modify_chance_basic_info");
        System.out.println("chance: "+chance);
        System.out.println();

        if (chance == null || chance.getChanceNum() == null || chance.getChanceNum().equals("") ||
                chance.getName() == null || chance.getName().equals("") ||
                chance.getChanceSourceId() == null || chance.getChanceSourceId() == 0 ||
                chance.getChanceStageId() == null || chance.getChanceStageId() == 0 ||
                chance.getPresignDate() == null || chance.getDeptId() == null || chance.getDeptId() == 0||
                chance.getBackground() == null || chance.getBackground().equals("") ||
                chance.getUserId() == null || chance.getUserId() == 0 ||
                chance.getClientId() == null || chance.getClientId() == 0 ||
                chance.getCreateDate() == null){
            return RespBean.error(400,"非法参数");
        }
        Chance isHere = iChanceService.getOne(Wrappers.<Chance>lambdaQuery()
                .eq(Chance::getChanceNum,chance.getChanceNum()));

        if (isHere == null)
            return RespBean.error(400,"非法参数");

        String clientName = iclientService.getById(chance.getClientId()).getName();
        iChanceService.update(Wrappers.<Chance>lambdaUpdate().eq(Chance::getChanceNum,chance.getChanceNum()).set(Chance::getClientName,clientName));
        iChanceService.update(chance,Wrappers.<Chance>lambdaUpdate().eq(Chance::getChanceNum,chance.getChanceNum()));

        return RespBean.ok(200,"更新成功");
    }

}