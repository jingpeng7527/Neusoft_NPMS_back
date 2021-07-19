package com.neusoft.npms.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neusoft.npms.dto.ApproveChanceDraft;
import com.neusoft.npms.dto.ChanceQueryCondition;
import com.neusoft.npms.entity.*;
import com.neusoft.npms.mapper.ChanceDraftMapper;
import com.neusoft.npms.mapper.ChanceMapper;
import com.neusoft.npms.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yky
 * @since 2021-07-13
 */
@Service
public class ChanceDraftServiceImpl extends ServiceImpl<ChanceDraftMapper, ChanceDraft> implements IChanceDraftService {

    @Autowired
    ChanceDraftMapper chanceDraftMapper;

    @Autowired
    ChanceMapper chanceMapper;

    @Autowired
    IChanceApproveLogService iChanceApproveLogService;

    @Autowired
    ISubChanceDraftService iSubChanceDraftService;

    @Autowired
    IChanceService iChanceService;

    @Autowired
    ISubChanceService iSubChanceService;

    public List<ChanceDraft> getChanceByCondition(ChanceQueryCondition chanceQueryCondition){
        return chanceDraftMapper.getChanceByCondition(chanceQueryCondition);
    }

    public List<ChanceDraft> getChanceWithChanceTypeAndProductNum(ChanceQueryCondition chanceQueryCondition){
        return chanceDraftMapper.getChanceWithChanceTypeAndProductNum(chanceQueryCondition);
    }

    public String generateChanceNum(){
        List<ChanceDraft> chanceDraft = chanceDraftMapper.selectList(Wrappers.<ChanceDraft>lambdaQuery().orderByDesc(ChanceDraft::getChanceNum).last("limit 0,1"));
        List<Chance> chance = chanceMapper.selectList(Wrappers.<Chance>lambdaQuery().orderByDesc(Chance::getChanceNum).last("limit 0,1"));
        // 两个都空
        if ((chanceDraft == null || chanceDraft.size() == 0) && (chance == null || chance.size() == 0)) return "20210001";
        else if (chanceDraft != null && chanceDraft.size()!= 0 && chance != null && chance.size() != 0 ){ // 两个都不空
            return String.valueOf(Integer.max(Integer.parseInt(chance.get(0).getChanceNum()),Integer.parseInt(chanceDraft.get(0).getChanceNum()))+1);
        } else if (chanceDraft == null || chanceDraft.size() == 0) { // 一个空
            return String.valueOf(Integer.parseInt(chance.get(0).getChanceNum())+1);
        } else {
            return String.valueOf(Integer.parseInt(chanceDraft.get(0).getChanceNum())+1);
        }
    }

    public boolean approve(ApproveChanceDraft approveChanceDraft,int role){ // 通过状态为 1
        // 生成审批日志
        generateChanceApproveLog(approveChanceDraft);

        // 修改状态
        if (role == 2) {// 审批人 role 营销副总
            update(Wrappers.<ChanceDraft>lambdaUpdate().eq(ChanceDraft::getChanceNum,approveChanceDraft.getChanceNum())
                    .set(ChanceDraft::getChanceStatusId,7 ));
            iSubChanceDraftService.update(Wrappers.<SubChanceDraft>lambdaUpdate().eq(SubChanceDraft::getChanceNum,approveChanceDraft.getChanceNum())
                    .set(SubChanceDraft::getSubChanceStatusId,5));
            return true;

        } else if (role == 3 || role == 4){ // 销售总监 事业部总经理（销售部二审）
            // 修改触发的审批
            if (getOne(Wrappers.<ChanceDraft>lambdaQuery().eq(ChanceDraft::getChanceNum,approveChanceDraft.getChanceNum())).getChanceStatusId().equals(8)) {
                // 更新状态
                update(Wrappers.<ChanceDraft>lambdaUpdate().eq(ChanceDraft::getChanceNum,approveChanceDraft.getChanceNum())
                        .set(ChanceDraft::getChanceStatusId,1));
                // 更新chance real 表
                Chance chance = new Chance(getOne(Wrappers.<ChanceDraft>lambdaQuery().eq(ChanceDraft::getChanceNum,approveChanceDraft.getChanceNum())));
                iChanceService.update(chance,Wrappers.<Chance>lambdaUpdate().eq(Chance::getChanceNum, approveChanceDraft.getChanceNum()));
                // 删掉 chance draft 表
                remove(Wrappers.<ChanceDraft>lambdaQuery().eq(ChanceDraft::getChanceNum,approveChanceDraft.getChanceNum()));
                // 更新sub chance 状态
                iSubChanceDraftService.update(Wrappers.<SubChanceDraft>lambdaUpdate().eq(SubChanceDraft::getChanceNum,approveChanceDraft.getChanceNum())
                        .set(SubChanceDraft::getSubChanceStatusId,1));
                // 更新sub chance real
                List<SubChanceDraft> tmp = iSubChanceDraftService.list(Wrappers.<SubChanceDraft>lambdaQuery().eq(SubChanceDraft::getChanceNum,approveChanceDraft.getChanceNum()));
                for (SubChanceDraft sub:tmp){
                    iSubChanceService.saveOrUpdate(new SubChance(sub), Wrappers.<SubChance>lambdaUpdate().eq(SubChance::getChanceNum,approveChanceDraft.getChanceNum()));
                }
                // 删掉 sub chance draft 表
                iSubChanceDraftService.remove(Wrappers.<SubChanceDraft>lambdaQuery().eq(SubChanceDraft::getChanceNum,approveChanceDraft.getChanceNum()));
                return true;
            }
            // update 状态
            update(Wrappers.<ChanceDraft>lambdaUpdate().eq(ChanceDraft::getChanceNum,approveChanceDraft.getChanceNum())
                    .set(ChanceDraft::getChanceStatusId,1 ));
            iSubChanceDraftService.update(Wrappers.<SubChanceDraft>lambdaUpdate().eq(SubChanceDraft::getChanceNum,approveChanceDraft.getChanceNum())
                    .set(SubChanceDraft::getSubChanceStatusId,1));

            // chance 导入real 表
            iChanceService.save(new Chance(getOne(Wrappers.<ChanceDraft>lambdaQuery().eq(ChanceDraft::getChanceNum,approveChanceDraft.getChanceNum()))));
            remove(Wrappers.<ChanceDraft>lambdaQuery().eq(ChanceDraft::getChanceNum,approveChanceDraft.getChanceNum()));
            // sub_chance 导入real表
            List<SubChance> saveList = new ArrayList<>();
            List<SubChanceDraft> tmp = iSubChanceDraftService.list(Wrappers.<SubChanceDraft>lambdaQuery().eq(SubChanceDraft::getChanceNum,approveChanceDraft.getChanceNum()));
            for (SubChanceDraft s:tmp)
                saveList.add(new SubChance(s));
            iSubChanceService.saveBatch(saveList);
            iSubChanceDraftService.remove(Wrappers.<SubChanceDraft>lambdaQuery().eq(SubChanceDraft::getChanceNum,approveChanceDraft.getChanceNum()));

            return true;
        } else return false;
    }

    public boolean back(ApproveChanceDraft approveChanceDraft,int role) { // 驳回
        // 生成审批日志
        generateChanceApproveLog(approveChanceDraft);

        if (role == 2) { // 营销副总 驳回

            update(Wrappers.<ChanceDraft>lambdaUpdate().eq(ChanceDraft::getChanceNum,approveChanceDraft.getChanceNum())
                    .set(ChanceDraft::getChanceStatusId,9 ));
            iSubChanceDraftService.update(Wrappers.<SubChanceDraft>lambdaUpdate().eq(SubChanceDraft::getChanceNum,approveChanceDraft.getChanceNum())
                    .set(SubChanceDraft::getSubChanceStatusId,5));
            return true;

        } else if (role == 3 || role == 4) { // 销售总监 事业部总经理 驳回
            update(Wrappers.<ChanceDraft>lambdaUpdate().eq(ChanceDraft::getChanceNum,approveChanceDraft.getChanceNum())
                    .set(ChanceDraft::getChanceStatusId,10 ));
            iSubChanceDraftService.update(Wrappers.<SubChanceDraft>lambdaUpdate().eq(SubChanceDraft::getChanceNum,approveChanceDraft.getChanceNum())
                    .set(SubChanceDraft::getSubChanceStatusId,5));
            return true;
        } else return false;
    }

    public boolean close(ApproveChanceDraft approveChanceDraft,int role){
        generateChanceApproveLog(approveChanceDraft);
        int chanceStatus = getOne(Wrappers.<ChanceDraft>lambdaQuery()
                .eq(ChanceDraft::getChanceNum,approveChanceDraft.getChanceNum())).getChanceStatusId();
        // 拒绝修改触发的审批
        if ( chanceStatus == 8){
            // 在草稿中删掉
            remove(Wrappers.<ChanceDraft>lambdaQuery().eq(ChanceDraft::getChanceNum,approveChanceDraft.getChanceNum()));
            iSubChanceDraftService.remove(Wrappers.<SubChanceDraft>lambdaQuery().eq(SubChanceDraft::getChanceNum,approveChanceDraft.getChanceNum()));
            return true;

        // 拒绝新增触发的审批
        } else if (chanceStatus == 6 || chanceStatus == 7 || chanceStatus == 9 || chanceStatus == 10 ){
            // 在草稿中修改状态
            update(Wrappers.<ChanceDraft>lambdaUpdate().eq(ChanceDraft::getChanceNum,approveChanceDraft.getChanceNum()).set(ChanceDraft::getChanceStatusId,3));
            iSubChanceDraftService.update(Wrappers.<SubChanceDraft>lambdaUpdate().eq(SubChanceDraft::getSubChanceNum,approveChanceDraft.getChanceNum()).set(SubChanceDraft::getSubChanceStatusId,3));

            // 更新至real表中
            iChanceService.save(new Chance(getOne(Wrappers.<ChanceDraft>lambdaQuery().eq(ChanceDraft::getChanceNum,approveChanceDraft.getChanceNum()))));
            List<SubChanceDraft> tmp = iSubChanceDraftService.list(Wrappers.<SubChanceDraft>lambdaQuery().eq(SubChanceDraft::getChanceNum,approveChanceDraft.getChanceNum()));
            List<SubChance> toSave = new ArrayList<>();
            for (SubChanceDraft s:tmp)
                toSave.add(new SubChance(s));
            iSubChanceService.saveBatch(toSave);

            // 在草稿中删掉
            remove(Wrappers.<ChanceDraft>lambdaQuery().eq(ChanceDraft::getChanceNum,approveChanceDraft.getChanceNum()));
            iSubChanceDraftService.remove(Wrappers.<SubChanceDraft>lambdaQuery().eq(SubChanceDraft::getChanceNum,approveChanceDraft.getChanceNum()));
            return true;

        } else {
            return false;
        }
    }

    private void generateChanceApproveLog(ApproveChanceDraft approveChanceDraft) {
        // 新建审批日志
        ChanceApproveLog chanceApproveLog = new ChanceApproveLog();
        chanceApproveLog.setApproveTime(LocalDateTime.now());
        chanceApproveLog.setChanceNum(Integer.parseInt(approveChanceDraft.getChanceNum()));
        if (approveChanceDraft.getContent() != null)
            chanceApproveLog.setContent(approveChanceDraft.getContent());
        chanceApproveLog.setName(getOne(Wrappers.<ChanceDraft>lambdaQuery()
                .eq(ChanceDraft::getChanceNum,approveChanceDraft.getChanceNum())).getName());
        chanceApproveLog.setOpinionTypeId(Integer.parseInt(approveChanceDraft.getOpinionTypeId()));
        chanceApproveLog.setUserId(Integer.parseInt(approveChanceDraft.getUserId()));
        iChanceApproveLogService.save(chanceApproveLog);
    }

}
