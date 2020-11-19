package com.yitu.hotel.controller;

import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.entity.common.Config;
import com.yitu.hotel.service.ConfigService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("config")
@CrossOrigin
public class ConfigController {

    @Autowired
    private ConfigService configService;

    /**
     * 获取字典数据（酒店类型，来源等等）
     *
     * @param config
     * @return com.yitu.hotel.model.JsonResult<java.util.List < com.yitu.hotel.entity.common.Config>>
     * @author zouhao
     * @date 2020/11/18 10:55
     */
    @ApiOperation(value = "获取参数信息", notes = "根据id获取参数信息")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public JsonResult<List<Config>> configList(Config config) {
        List<Config> configList = configService.configList(config);
        return JsonResult.ok(configList);
    }

}
