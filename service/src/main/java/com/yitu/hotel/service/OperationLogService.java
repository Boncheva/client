package com.yitu.hotel.service;

import com.yitu.hotel.entity.common.OperationLog;

public interface OperationLogService {

    /**
     * 保存日志
     * @param ol
     * @return void
     * @author zouhao
     * @date 2020/11/18 18:52
     */
    void saveLog(OperationLog ol);
}
