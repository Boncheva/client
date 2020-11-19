package com.yitu.hotel.service;

import com.yitu.hotel.entity.common.Config;

import java.util.List;

public interface ConfigService {

    /**
     * 获取字典数据（酒店类型，来源等等）
     *
     * @param config
     * @return com.yitu.hotel.model.JsonResult<java.util.List < com.yitu.hotel.entity.common.Config>>
     * @author zouhao
     * @date 2020/11/18 10:55
     */
    List<Config> configList(Config config);
}
