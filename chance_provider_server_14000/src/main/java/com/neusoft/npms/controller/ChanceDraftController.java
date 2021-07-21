package com.neusoft.npms.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neusoft.npms.dto.ApproveChanceDraft;
import com.neusoft.npms.dto.RespBean;
import com.neusoft.npms.dto.ReturnChanceBasicInfo;
import com.neusoft.npms.dto.ReturnSubChance;
import com.neusoft.npms.entity.Chance;
import com.neusoft.npms.entity.ChanceDraft;
import com.neusoft.npms.entity.SubChanceDraft;
import com.neusoft.npms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
@RequestMapping("/npms/chance-draft")
public class ChanceDraftController {

    @Autowired
    IChanceDraftService iChanceDraftService;
    @Autowired
    IUserService iUserService;
    @Autowired
    IChanceSourceService iChanceSourceService;
    @Autowired
    IChanceStageService iChanceStageService;
    @Autowired
    IDeptService iDeptService;
    @Autowired
    IChanceStatusService iChanceStatusService;
    @Autowired
    IClientService iClientService;
    @Autowired
    ISubChanceDraftService iSubChanceDraftService;
    @Autowired
    IChanceTypeProductService iChanceTypeProductService;
    @Autowired
    IChanceService iChanceService;

    @PostMapping("/save_chance_in_draft")
    public RespBean saveChance (@RequestBody Chance chance){
        System.out.println("/save_chance_in_draft");
        System.out.println(chance);
        System.out.println();
        if (chance == null) return RespBean.error(400,"参数为空");

        // 设置为草稿状态
        chance.setChanceStatusId(4);
        // 新增 生成 chanceNum， 设置创建时间，
        try{
            if (chance.getChanceNum() == null || chance.getChanceNum().equals("")){
                System.out.println("为空"+chance.getChanceNum());
                String chanceNum = iChanceDraftService.generateChanceNum();
                System.out.println("chanceNum:"+chanceNum);
                chance.setClientName(iClientService.getById(chance.getClientId()).getName());
                chance.setChanceNum(chanceNum);
                chance.setCreateDate(LocalDate.now());
                iChanceDraftService.save(new ChanceDraft(chance));
            } else {
                System.out.println("不为空"+chance.getChanceNum());
                chance.setClientName(iClientService.getById(chance.getClientId()).getName());
                iChanceDraftService.saveOrUpdate(new ChanceDraft(chance),Wrappers.<ChanceDraft>lambdaUpdate().eq(ChanceDraft::getChanceNum,chance.getChanceNum()));
            }
            return RespBean.ok(200,"保存为草稿",chance);
        } catch (Exception e){
            System.out.println(e);
            return RespBean.error(500,"发生未知错误快改库");
        }

    }

    @GetMapping("/get_TOApprove_chance_list_by_user_id")
    public RespBean getTOApproveChanceListByUserId(String userId){
        System.out.println("/get_TOApprove_chance_list_by_user_id");
        System.out.println("userId" + userId);
        System.out.println();
        if (userId == null || userId.equals("")) return RespBean.error(400,"参数为空");

        int roleId = iUserService.getById(userId).getRoleId();
        // 权限管理
        if (roleId == 2) {// 营销副总 (初审)
            List<ReturnChanceBasicInfo> returnList = new ArrayList<>();

            List<ChanceDraft> result = iChanceDraftService.list(Wrappers.<ChanceDraft>lambdaQuery().eq(ChanceDraft::getChanceStatusId,6));
            for (ChanceDraft c:result)
                returnList.add(new ReturnChanceBasicInfo(c,iChanceSourceService,iChanceStageService,iDeptService ,iUserService,iChanceStatusService));
            return RespBean.ok(200,"初审机会列表",returnList);

        } else if (roleId == 3) { // 销售总监 （销售部二审）
            List<ReturnChanceBasicInfo> returnList = new ArrayList<>();

            List<ChanceDraft> result = iChanceDraftService.list(Wrappers.<ChanceDraft>lambdaQuery()
                    .lt(ChanceDraft::getDeptId,9).and(w->w.eq(ChanceDraft::getChanceStatusId,7).or().eq(ChanceDraft::getChanceStatusId,8)));
            for (ChanceDraft c:result)
                returnList.add(new ReturnChanceBasicInfo(c,iChanceSourceService,iChanceStageService,iDeptService ,iUserService,iChanceStatusService));
            return RespBean.ok(200,"销售部二审列表",returnList);

        } else if (roleId == 4) { // 事业部总经理 （事业部二审）
            List<ReturnChanceBasicInfo> returnList = new ArrayList<>();

            List<ChanceDraft> result = iChanceDraftService.list(Wrappers.<ChanceDraft>lambdaQuery()
                    .gt(ChanceDraft::getDeptId,8).and(w->w.eq(ChanceDraft::getChanceStatusId,7).or().or().eq(ChanceDraft::getChanceStatusId,8)));
            for (ChanceDraft c:result)
                returnList.add(new ReturnChanceBasicInfo(c,iChanceSourceService,iChanceStageService,iDeptService ,iUserService,iChanceStatusService));
            return RespBean.ok(200,"事业部二审列表",returnList);
        } else {
            return RespBean.error(403,"无权利审批");
        }
    }

    @GetMapping("/get_TOApprove_chance_basic_info_by_chance_num")
    public RespBean getTPApproveChanceBasicInfoByChanceNum(String chanceNum){
        System.out.println("/get_TOApprove_chance_basic_info_by_chance_num");
        System.out.println("chanceNum:" + chanceNum);
        System.out.println();

        if (chanceNum == null || chanceNum.equals(""))
            return RespBean.error(400,"参数为空");

        ChanceDraft chanceDraft = iChanceDraftService.getOne(Wrappers.<ChanceDraft>lambdaQuery().eq(ChanceDraft::getChanceNum,chanceNum));

        return RespBean.ok(200,"通过chanceNum 获取待审批的chance的basicInfo",new ReturnChanceBasicInfo(chanceDraft,iChanceSourceService,iChanceStageService,iDeptService ,iUserService,iChanceStatusService));
    }

    @GetMapping("/get_TOApprove_sub_chance_list_by_chance_num")
    public RespBean getTPApproveSubChanceListByChanceNum(String chanceNum){
        System.out.println("/get_TOApprove_sub_chance_list_by_chance_num");
        System.out.println("chanceNum: "+chanceNum);
        System.out.println();

        if (chanceNum == null || chanceNum.equals(""))
            return RespBean.error(400,"参数为空");

        List<SubChanceDraft> result = iSubChanceDraftService.list(Wrappers.<SubChanceDraft>lambdaQuery()
                .eq(SubChanceDraft::getChanceNum,chanceNum));

        List<ReturnSubChance> returnList = new ArrayList<>();

        for (SubChanceDraft s:result)
            returnList.add(new ReturnSubChance(s,iChanceTypeProductService,iDeptService,iChanceStatusService));

        return RespBean.ok(200,"获取待审批的机会下的所有子机会", returnList);
    }

    @PostMapping("/approve_chance_draft_by_chance_num")
    public RespBean approveChanceDraftByChanceNum(@RequestBody ApproveChanceDraft approveChanceDraft){
        System.out.println("/approve_chance_draft_by_chance_num");
        System.out.println("approveChanceDraft: "+ approveChanceDraft);
        System.out.println();

        boolean returnState = false;
        // 参数判断
        if (approveChanceDraft == null ||
                approveChanceDraft.getChanceNum() == null || approveChanceDraft.getChanceNum().equals("") ||
                approveChanceDraft.getOpinionTypeId() == null || approveChanceDraft.getOpinionTypeId().equals("") ||
                approveChanceDraft.getUserId() == null || approveChanceDraft.getUserId().equals(""))
            return RespBean.error(400, "非法参数1");
        if (approveChanceDraft.getOpinionTypeId().equals("2") || approveChanceDraft.getOpinionTypeId().equals("3")) {
            if (approveChanceDraft.getContent() == null || approveChanceDraft.getContent().equals(""))
                return RespBean.error(400, "非法参数2");
        }

        // 权限管理
        int role  = iUserService.getById(approveChanceDraft.getUserId()).getRoleId();
        if (role == 2) { // 营销副总 (初审)
            if (approveChanceDraft.getOpinionTypeId().equals("1")) { // 通过
                returnState = iChanceDraftService.approve(approveChanceDraft,role);
                if (returnState) return RespBean.ok(200,"营销副总审批通过");
                else return RespBean.error(500,"发生未知错误或参数错误——营销副总审批通过");

            } else if (approveChanceDraft.getOpinionTypeId().equals("2")) { // 打回
                returnState = iChanceDraftService.back(approveChanceDraft,role);
                if (returnState) return RespBean.ok(200, "营销副总驳回");
                else return RespBean.error(500,"发生未知错误或参数错误——营销副总驳回");

            } else if (approveChanceDraft.getOpinionTypeId().equals("3")) { // 关闭
                returnState = iChanceDraftService.close(approveChanceDraft,role);
                if (returnState) return RespBean.ok(200, "营销副总审批拒绝（关闭）");
                else return RespBean.error(500, "发生未知错误或参数错误——营销副总审批拒绝（关闭）");
            } else
                return RespBean.error(400,"非法参数3");
        } else if (role == 3) { // 销售总监 （销售部二审）
            if (approveChanceDraft.getOpinionTypeId().equals("1")) {
                returnState = iChanceDraftService.approve(approveChanceDraft,role);
                if (returnState) return RespBean.ok(200,"销售总监审批通过");
                else return RespBean.error(500,"发生未知错误或参数错误——销售总监审批通过");
            } else if (approveChanceDraft.getOpinionTypeId().equals("2")) {
                returnState = iChanceDraftService.back(approveChanceDraft,role);
                if (returnState) return RespBean.ok(200, "销售总监驳回");
                else return RespBean.error(500,"发生未知错误或参数错误——销售总监驳回");

            } else if (approveChanceDraft.getOpinionTypeId().equals("3")) {
                returnState = iChanceDraftService.close(approveChanceDraft,role);
                if (returnState) return RespBean.ok(200,"销售总监审批拒绝（关闭）");
                return RespBean.ok(500, "发生未知错误或参数错误——销售总监审批拒绝（关闭）");
            } else
                return RespBean.error(400,"非法参数4");
        } else if (role == 4) { // 事业部总经理 （事业部二审）
            if (approveChanceDraft.getOpinionTypeId().equals("1")) {
                returnState = iChanceDraftService.approve(approveChanceDraft, role);
                if (returnState) return RespBean.ok(200,"事业部总经理审批通过");
                else return RespBean.error(500, "发生未知错误或参数错误——事业部总经理审批通过");

            } else if (approveChanceDraft.getOpinionTypeId().equals("2")) {
                returnState = iChanceDraftService.back(approveChanceDraft,role);
                if (returnState) return RespBean.ok(200, "事业部总经理驳回");
                else return RespBean.error(500,"发生未知错误或参数错误——事业部总经理驳回");

            } else if (approveChanceDraft.getOpinionTypeId().equals("3")) {
                returnState = iChanceDraftService.close(approveChanceDraft,role);
                if (returnState) return RespBean.ok(200, "事业部总经理拒绝（关闭）");
                else return RespBean.error(500, "发生未知错误或参数错误——事业部总经理拒绝（关闭）");
            } else
                return RespBean.error(400,"非法参数5");
        } else {
            return RespBean.error(403,"没有权限进行该操作");
        }
    }

    // 1 新增 2 修改不审批 3 修改审批
    @GetMapping("/submit")
    public RespBean submit (String chanceNum, String isProcess){
        System.out.println("/submit");
        System.out.println("chanceNum: "+ chanceNum + "isProcess: "+ isProcess);
        System.out.println();

        if (chanceNum == null || chanceNum.equals("") || isProcess == null || isProcess.equals(""))
            return RespBean.error(400,"非法参数");

        boolean updateChanceBaiscInfo;
        boolean updateSubChance;

        // 草稿表中没有 是修改触发的审批
        ChanceDraft tmp1 = iChanceDraftService.getOne(Wrappers.<ChanceDraft>lambdaQuery().eq(ChanceDraft::getChanceNum,chanceNum));

        if (isProcess.equals("1")) {
            // 修改机会基本信息的状态为 新增流程中 6
            updateChanceBaiscInfo = iChanceDraftService.update(Wrappers.<ChanceDraft>lambdaUpdate().eq(ChanceDraft::getChanceNum,chanceNum).set(ChanceDraft::getChanceStatusId,6));
            updateSubChance = iSubChanceDraftService.update(Wrappers.<SubChanceDraft>lambdaUpdate().eq(SubChanceDraft::getChanceNum,chanceNum).set(SubChanceDraft::getSubChanceStatusId,5));
            if (updateChanceBaiscInfo && updateSubChance)
                return RespBean.ok(200,"提交成功");
            else return RespBean.error(500,"未知错误，快看库");
        } else if (isProcess.equals("2")) {
            return RespBean.error(403,"无权访问");
        } else if (isProcess.equals("3")) {
            updateChanceBaiscInfo = iChanceDraftService.update(Wrappers.<ChanceDraft>lambdaUpdate().eq(ChanceDraft::getChanceNum,chanceNum).set(ChanceDraft::getChanceStatusId,8));
            updateSubChance = iSubChanceDraftService.update(Wrappers.<SubChanceDraft>lambdaUpdate().eq(SubChanceDraft::getChanceNum,chanceNum).set(SubChanceDraft::getSubChanceStatusId,5));
            if (updateChanceBaiscInfo && updateSubChance)
                return RespBean.ok(200,"提交成功");
            else return RespBean.error(500,"未知错误，快看库");
        } else
            return RespBean.error(400,"非法参数");


    }
}

