package com.neusoft.npms.service.impl;

import com.neusoft.npms.dto.SalesLogQueryCondition;
import com.neusoft.npms.entity.SalesLog;
import com.neusoft.npms.mapper.SalesLogMapper;
import com.neusoft.npms.service.ISalesLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
public class SalesLogServiceImpl extends ServiceImpl<SalesLogMapper, SalesLog> implements ISalesLogService {

    @Autowired
    SalesLogMapper salesLogMapper;

    public List<SalesLog> getByIdAndTime(String userid, LocalDate startTime, LocalDate endTime){
        SalesLogQueryCondition queryCondition = new SalesLogQueryCondition(userid, startTime,endTime);
        List<SalesLog> list = salesLogMapper.getByIdAndTime(queryCondition);
        return list;
    }
}
