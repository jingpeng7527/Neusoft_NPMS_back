package com.neusoft.npms;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neusoft.npms.dto.ChanceQueryCondition;
import com.neusoft.npms.dto.ReturnPolicyMaker;
import com.neusoft.npms.entity.*;
import com.neusoft.npms.mapper.ChanceDraftMapper;
import com.neusoft.npms.mapper.ChanceMapper;
import com.neusoft.npms.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class test {

//    @Autowired
//    IChanceTypeProductService chanceTypeProductService;
//    @Test
//    public void test(){
//        ChanceQueryCondition chanceQueryCondition = new ChanceQueryCondition();
//        chanceQueryCondition.setProductNum("SAP");
//        List<ChanceTypeProduct> list = chanceTypeProductService.getItemsByChanceAndProduct(chanceQueryCondition);
//        for (ChanceTypeProduct a:list) System.out.println(a);
//    }
    @Autowired
    ChanceMapper chanceMapper;

    @Autowired
    ChanceDraftMapper chanceDraftMapper;

    @Autowired
    IChanceService iChanceService;

    @Autowired
    IChanceDraftService iChanceDraftService;

    @Autowired
    IPolicymakerService iPolicymakerService;

    @Autowired
    IEffectLevelService iEffectLevelService;

    @Autowired
    IRecognitionLevelService iRecognitionLevelService;

    @Autowired
    ISubChanceDraftService iSubChanceDraftService;

    @Autowired
    ISubChanceService iSubChanceService;

    @Test
    public void test1(){
        ChanceQueryCondition chanceQueryCondition = new ChanceQueryCondition();
        chanceQueryCondition.setProductNum("SAP");

        System.out.println(chanceMapper.getChanceWithChanceTypeAndProductNum(chanceQueryCondition));
    }

    @Test
    public void test2(){
        List<ChanceDraft> chanceDraft = chanceDraftMapper.selectList(Wrappers.<ChanceDraft>lambdaQuery().orderByDesc(ChanceDraft::getChanceNum).last("limit 0,1"));
        System.out.println("11111");
        for (ChanceDraft c:chanceDraft){
            System.out.println(c);
        }
    }

    @Test
    public void test3(){
        List<Chance> chance = chanceMapper.selectList(Wrappers.<Chance>lambdaQuery().orderByDesc(Chance::getChanceNum).last("limit 0,1"));
        for (Chance c:chance) System.out.println(c);
    }

    @Test
    public void test4(){
        List<Chance> chanceList = iChanceService.list(Wrappers.<Chance>lambdaQuery().eq(Chance::getChanceNum,"123"));
        System.out.println(chanceList.size());
    }

    @Test
    public void test5(){
        List<ChanceDraft> result = iChanceDraftService.list(Wrappers.<ChanceDraft>lambdaQuery()
                .eq(ChanceDraft::getChanceStatusId,1).lt(ChanceDraft::getDeptId,8));
        for (ChanceDraft c:result) System.out.println(c);
    }

    @Test
    public void test6(){
        List<Policymaker> result = iPolicymakerService.
                list(Wrappers.<Policymaker>lambdaQuery().eq(Policymaker::getChanceNum,"20210001"));

        List<ReturnPolicyMaker> returnList = new ArrayList<>();
        for (Policymaker policymaker:result)
            returnList.add(new ReturnPolicyMaker(policymaker,iPolicymakerService,iEffectLevelService, iRecognitionLevelService));

        for (ReturnPolicyMaker r:returnList)
            System.out.println(r);

//        ChanceDraft chanceDraft = iChanceDraftService.getOne(Wrappers.<ChanceDraft>lambdaQuery().eq(ChanceDraft::getChanceNum,"20210007"));
//        System.out.println(new ReturnChanceBasicInfo(chanceDraft));
    }

    @Test
    public void test7(){
        iChanceDraftService.update(Wrappers.<ChanceDraft>lambdaUpdate().eq(ChanceDraft::getChanceNum,"20210005")
                .set(ChanceDraft::getChanceStatusId,7 ));
        iSubChanceDraftService.update(Wrappers.<SubChanceDraft>lambdaUpdate().eq(SubChanceDraft::getChanceNum,"20210005")
                .set(SubChanceDraft::getSubChanceStatusId,5));
    }

    @Test
    public void test8(){
        iChanceDraftService.update(Wrappers.<ChanceDraft>lambdaUpdate().eq(ChanceDraft::getChanceNum,"20210005")
                .set(ChanceDraft::getChanceStatusId,1 ));
        iSubChanceDraftService.update(Wrappers.<SubChanceDraft>lambdaUpdate().eq(SubChanceDraft::getChanceNum,"20210005")
                .set(SubChanceDraft::getSubChanceStatusId,1));
        // 导入real 表
        iChanceService.save(new Chance(iChanceDraftService.getOne(Wrappers.<ChanceDraft>lambdaQuery().eq(ChanceDraft::getChanceNum,"20210005"))));
        iChanceDraftService.remove(Wrappers.<ChanceDraft>lambdaQuery().eq(ChanceDraft::getChanceNum,"20210005"));

        List<SubChance> saveList = new ArrayList<>();
        List<SubChanceDraft> tmp = iSubChanceDraftService.list(Wrappers.<SubChanceDraft>lambdaQuery().eq(SubChanceDraft::getChanceNum,"20210005"));
        for (SubChanceDraft s:tmp)
            saveList.add(new SubChance(s));
        iSubChanceService.saveBatch(saveList);


    }

    @Test
    public void test9() {
        // 更新状态
        iChanceDraftService.update(Wrappers.<ChanceDraft>lambdaUpdate().eq(ChanceDraft::getChanceNum,"20210009")
                .set(ChanceDraft::getChanceStatusId,1));
        // 更新chance real 表
        Chance chance = new Chance(iChanceDraftService.getOne(Wrappers.<ChanceDraft>lambdaQuery().eq(ChanceDraft::getChanceNum,"20210009")));
        iChanceService.update(chance,Wrappers.<Chance>lambdaUpdate().eq(Chance::getChanceNum, "20210009"));
        // 删掉 chance draft 表
        iChanceDraftService.remove(Wrappers.<ChanceDraft>lambdaQuery().eq(ChanceDraft::getChanceNum,"20210009"));
        // 更新sub chance 状态
        iSubChanceDraftService.update(Wrappers.<SubChanceDraft>lambdaUpdate().eq(SubChanceDraft::getChanceNum,"20210009")
                .set(SubChanceDraft::getSubChanceStatusId,1));
        // 更新sub chance real
        List<SubChanceDraft> tmp = iSubChanceDraftService.list(Wrappers.<SubChanceDraft>lambdaQuery().eq(SubChanceDraft::getChanceNum,"20210009"));
        for (SubChanceDraft sub:tmp){
            iSubChanceService.saveOrUpdate(new SubChance(sub), Wrappers.<SubChance>lambdaUpdate().eq(SubChance::getChanceNum,"20210009"));
        }
        // 删掉 sub chance draft 表
        iSubChanceDraftService.remove(Wrappers.<SubChanceDraft>lambdaQuery().eq(SubChanceDraft::getChanceNum,"20210009"));
    }

    @Test
    void test10(){
        List<ChanceDraft> result = iChanceDraftService.list(Wrappers.<ChanceDraft>lambdaQuery().eq(ChanceDraft::getChanceStatusId,6).or().eq(ChanceDraft::getChanceStatusId,9).or().eq(ChanceDraft::getChanceStatusId,4));
        for (ChanceDraft c:result)
            System.out.println(c);
    }

    @Test
    void test12(){
        System.out.println(iChanceDraftService.update(Wrappers.<ChanceDraft>lambdaUpdate().eq(ChanceDraft::getChanceNum,"20210006").set(ChanceDraft::getChanceStatusId,6)));
    }

    @Test
    void test11(){
        List<ChanceDraft> result = iChanceDraftService.list(Wrappers.<ChanceDraft>lambdaQuery()
                .lt(ChanceDraft::getDeptId,9).and(draftQueryWrapper->draftQueryWrapper.eq(ChanceDraft::getChanceStatusId,7).or().eq(ChanceDraft::getChanceStatusId,10).or().eq(ChanceDraft::getChanceStatusId,8)));

        for (ChanceDraft c:result)
            System.out.println(c);
    }

    @Test
    void tmp(){
        List<SubChance> saveList = new ArrayList<>();
        List<SubChanceDraft> tmp = iSubChanceDraftService.list(Wrappers.<SubChanceDraft>lambdaQuery().eq(SubChanceDraft::getChanceNum,"20210005"));
        for (SubChanceDraft s:tmp)
            saveList.add(new SubChance(s));
        iSubChanceService.saveBatch(saveList);

        iSubChanceDraftService.remove(Wrappers.<SubChanceDraft>lambdaQuery().eq(SubChanceDraft::getChanceNum,"20210005"));
    }


}
