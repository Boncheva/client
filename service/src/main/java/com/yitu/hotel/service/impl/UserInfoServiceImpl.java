package com.yitu.hotel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yitu.hotel.dto.user.UserDto;
import com.yitu.hotel.exception.CustomException;
import com.yitu.hotel.mapper.DgtxPlacesMapper;
import com.yitu.hotel.mapper.UserMapper;
import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.entity.common.DgtxPlaces;
import com.yitu.hotel.entity.user.User;
import com.yitu.hotel.service.UserInfoService;
import com.yitu.hotel.vo.user.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DgtxPlacesMapper dgtxPlacesMapper;

    /**
     * 获取用户列表
     *
     * @param userDto
     * @return com.github.pagehelper.PageInfo<com.yitu.hotel.vo.user.UserVo>
     * @author zouhao
     * @date 2020/11/18 11:11
     */
    @Override
    public PageInfo<UserVo> getUserInfoList(UserDto userDto) {
        PageHelper.startPage(userDto.getPageNum(), userDto.getPageSize());
        List<UserVo> list = userMapper.getList(userDto);
        PageInfo<UserVo> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * 根据条件获取区域列表(省市区)
     *
     * @param dgtxPlaces
     * @return java.util.List<com.yitu.hotel.entity.common.DgtxPlaces>
     * @author zouhao
     * @date 2020/11/18 14:35
     */
    @Override
    public List<DgtxPlaces> getAreaList(DgtxPlaces dgtxPlaces) {
        List<DgtxPlaces> dgtxPlacesList;
        QueryWrapper qw;
        if (dgtxPlaces.getId() != null) {
            dgtxPlaces = dgtxPlacesMapper.selectById(dgtxPlaces.getId());
            qw = new QueryWrapper();
            qw.eq("parent_id", dgtxPlaces.getId());
        } else {
            qw = new QueryWrapper();
            qw.eq("ctype", 1);
        }
        return dgtxPlacesMapper.selectList(qw);
    }

    /**
     * 根据用户id获取用户信息
     *
     * @param userId
     * @return com.yitu.hotel.entity.user.User
     * @author zouhao
     * @date 2020/11/18 14:36
     */
    @Override
    public JsonResult<UserVo> getUserInfo(String userId) {
        if (StringUtils.isBlank(userId)) {
            throw new CustomException("参数有误");
        }
        User user = userMapper.selectById(userId);
        if (user == null) {
            throw new CustomException("该用户不存在");
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return JsonResult.ok(userVo);
    }

    /**
     * 据用户id重置用户密码
     *
     * @param userDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 14:36
     */
    @Override
    public JsonResult restPwd(UserDto userDto) {
        if (StringUtils.isBlank(userDto.getId())) {
            throw new CustomException("参数有误");
        }
        if (StringUtils.isBlank(userDto.getPasswd())) {
            throw new CustomException("密码不能为空");
        } else {
            if (userDto.getPasswd().length() < 8) {
                throw new CustomException("密码长度不能少于8位");
            }
        }
        User user = userMapper.selectById(userDto.getId());
        if (user == null) {
            throw new CustomException("该用户不存在");
        }
        user = new User();
        user.setId(Long.parseLong(userDto.getId()));
        user.setPasswd(userDto.getPasswd());
        int i = userMapper.updateById(user);
        if (i <= 0) {
            throw new CustomException("系统错误，修改失败");
        }
        return JsonResult.ok();
    }

    /**
     * 根据用户id删除用户信息
     *
     * @param userId
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 14:36
     */
    @Override
    public JsonResult deleteUser(String userId) {
        int i = userMapper.deleteById(userId);
        if (i <= 0) {
            throw new CustomException("系统错误，删除失败");
        }
        return JsonResult.ok();
    }
}
