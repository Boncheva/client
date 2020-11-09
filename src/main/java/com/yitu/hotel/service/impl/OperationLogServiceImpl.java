package com.yitu.hotel.service.impl;

import com.yitu.hotel.mapper.OperationLogMapper;
import com.yitu.hotel.model.entity.OperationLog;
import com.yitu.hotel.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Autowired
    private OperationLogMapper operationLogMapper;

    @Override
    public void saveLog(OperationLog ol) {
        operationLogMapper.insert(ol);
    }
}
