package com.yitu.hotel.service.impl;

import com.yitu.hotel.mapper.OperationLogMapper;
import com.yitu.hotel.entity.common.OperationLog;
import com.yitu.hotel.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Autowired
    private OperationLogMapper operationLogMapper;

    /**
     * 保存日志
     * @param ol
     * @return void
     * @author zouhao
     * @date 2020/11/18 18:52
     */
    @Override
    public void saveLog(OperationLog ol) {
        operationLogMapper.insert(ol);
    }
}
