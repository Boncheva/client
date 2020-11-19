package com.yitu.hotel.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yitu.hotel.dto.user.UserDto;
import com.yitu.hotel.entity.user.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yitu.hotel.vo.user.UserVo;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author MyBatisPlusGenerater
 * @since 2020-10-29
 */
public interface UserMapper extends BaseMapper<User> {

    /***
     * 查询用户信息列表
     * @param userDto
     * @return java.util.List<com.yitu.hotel.entity.user.User>
     * @author zouhao
     * @date 2020/11/18 14:06
     */
    List<UserVo> getList(UserDto userDto);
}
