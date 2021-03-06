package com.yitu.hotel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yitu.hotel.mapper.ConfigMapper;
import com.yitu.hotel.entity.common.Config;
import com.yitu.hotel.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigMapper configMapper;

    /**
     * 获取字典数据（酒店类型，来源等等）
     *
     * @param config
     * @return com.yitu.hotel.model.JsonResult<java.util.List < com.yitu.hotel.entity.common.Config>>
     * @author zouhao
     * @date 2020/11/18 10:55
     */
    @Override
    public List<Config> configList(Config config) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (config.getParentId() != null) {
            queryWrapper.eq("parent_id", config.getParentId());
        }
        return configMapper.selectList(queryWrapper);
    }
}
