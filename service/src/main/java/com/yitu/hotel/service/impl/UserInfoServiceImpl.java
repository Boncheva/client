package com.yitu.hotel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yitu.hotel.mapper.DgtxPlacesMapper;
import com.yitu.hotel.mapper.UserMapper;
import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.model.entity.DgtxPlaces;
import com.yitu.hotel.model.entity.User;
import com.yitu.hotel.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
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
     * @param user
     * @return
     */
    @Override
    public PageInfo<User> getUserInfoList(User user) {
        PageHelper.startPage(user.getPageNum(), user.getPageSize());
        QueryWrapper qw = new QueryWrapper();
        if (StringUtils.isNotBlank(user.getProvince())) {
            qw.eq("province", user.getProvince());
        }
        if (StringUtils.isNotBlank(user.getCity())) {
            qw.eq("city", user.getCity());
        }
        if (StringUtils.isNotBlank(user.getArea())) {
            qw.eq("area", user.getArea());
        }
        if (StringUtils.isNotBlank(user.getIsSubmit())) {
            if ("1".equals(user.getIsSubmit())) {
                qw.isNotNull("report_path");
            } else {
                qw.isNull("report_path");
            }
        }
        if (user.getDeleted() != null) {
            qw.eq("deleted", user.getDeleted());
        }
        if (user.getFillStatus() != null) {
            qw.eq("fill_status", user.getFillStatus());
        }
        if (user.getUserType() != null) {
            qw.eq("user_type", user.getUserType());
        }
        if (StringUtils.isNotBlank(user.getIdOrName())) {
            qw.apply("( user_name like '%" + user.getIdOrName() + "%' or cert_no = '" + user.getIdOrName() + "')");
        }
        qw.select("id,cert_type,cert_no,user_name,check_status,sq_check_status,hs_rg_check_status,user_type,from_type,report_path,deleted");
        List<User> list = userMapper.selectList(qw);
        PageInfo<User> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * 根据条件获取区域列表(省市区)
     *
     * @param dgtxPlaces
     * @return
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
     * @return
     */
    @Override
    public User getUserInfo(String userId) {
        QueryWrapper qw;
        User user = userMapper.selectById(userId);
        return user;
    }

    /**
     * 根据用户id重置用户密码
     *
     * @param user
     * @return
     */
    @Override
    public JsonResult restPwd(User user) {
        try {
            userMapper.updateById(user);
        } catch (RuntimeException e) {
            return JsonResult.fail("失败");
        }
        return JsonResult.ok();
    }

    /**
     * 根据用户id删除用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public JsonResult deleteUser(String userId) {
        try {
            userMapper.deleteById(userId);
        } catch (RuntimeException e) {
            return JsonResult.fail("失败");
        }
        return JsonResult.ok();
    }
}
