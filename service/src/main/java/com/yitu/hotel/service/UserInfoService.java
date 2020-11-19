package com.yitu.hotel.service;

import com.github.pagehelper.PageInfo;
import com.yitu.hotel.dto.user.UserDto;
import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.entity.common.DgtxPlaces;
import com.yitu.hotel.vo.user.UserVo;

import java.util.List;

public interface UserInfoService {

    /**
     * 获取用户列表
     *
     * @param userDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:08
     */
    PageInfo<UserVo> getUserInfoList(UserDto userDto);

    /**
     * 根据条件获取区域列表(省市区)
     *
     * @param dgtxPlaces
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:09
     */
    List<DgtxPlaces> getAreaList(DgtxPlaces dgtxPlaces);

    /**
     * 根据用户id获取用户信息
     *
     * @param userId
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:09
     */
    JsonResult<UserVo> getUserInfo(String userId);

    /**
     * 根据用户id重置用户密码
     *
     * @param userDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:09
     */
    JsonResult restPwd(UserDto userDto);

    /**
     * 根据用户id删除用户信息
     *
     * @param userId
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:09
     */
    JsonResult deleteUser(String userId);
}
