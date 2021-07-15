package com.neusoft.npms.service;

import com.neusoft.npms.entity.SalesLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yky
 * @since 2021-07-13
 */
public interface ISalesLogService extends IService<SalesLog> {
    List<SalesLog> getByIdAndTime(String userid, LocalDate startTime, LocalDate endTime, String week);
}
