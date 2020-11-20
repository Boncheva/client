package com.yitu.hotel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yitu.hotel.dto.adminUser.AdminUserDto;
import com.yitu.hotel.exception.CustomException;
import com.yitu.hotel.mapper.AdminUserMapper;
import com.yitu.hotel.mapper.TokenMapper;
import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.entity.adminUser.AdminUser;
import com.yitu.hotel.entity.adminUser.Token;
import com.yitu.hotel.service.AdminUserService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private TokenMapper tokenMapper;

    /**
     * 用户登录
     *
     * @param adminUserDto
     * @param request
     * @return
     */
    @Override
    public JsonResult login(AdminUserDto adminUserDto, HttpServletRequest request) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("mobile", adminUserDto.getMobile());
        qw.eq("passwd", adminUserDto.getPasswd());
        AdminUser result = adminUserMapper.selectOne(qw);
        if (result == null) {
            log.error("用户名或密码错误");
            throw new CustomException("用户名或密码错误");
        }
        //验证通过，绑定token
        Map<String, Object> map = new HashMap();
        String Token = operateToKen(result, result.getId());
        map.put("userToken", Token);
        map.put("userInfo", result);
        return JsonResult.ok(map);
    }

    @Override
    public JsonResult signOut(String token) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("token", token);
        tokenMapper.delete(qw);
        return JsonResult.ok();
    }

    /**
     * 根据情况生成后者更新用户token
     *
     * @param user
     * @param userId
     * @return
     */
    private String operateToKen(AdminUser user, long userId) {
        //根据数据库的用户信息查询Token
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id", userId);
        Token token = tokenMapper.selectOne(qw);
        //为生成Token准备
        String TokenStr = "";
        Date date = new Date();
        int nowTime = (int) (date.getTime() / 1000);
        //生成Token
        TokenStr = creatToken(userId, date);
        if (null == token) {
            //第一次登陆
            token = new Token();
            token.setToken(TokenStr);
            token.setBuildTime(nowTime);
            token.setUserId(Integer.parseInt(String.valueOf(userId)));
            tokenMapper.insert(token);
        } else {
            //登陆就更新Token信息
            TokenStr = creatToken(userId, date);
            token.setToken(TokenStr);
            token.setBuildTime(nowTime);
            int result = tokenMapper.updateById(token);
            if (result <= 0) {
                throw new CustomException("更新token失败");
            }
        }
        return TokenStr;
    }

    private String creatToken(Long userId, Date date) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT") // 设置header
                .setHeaderParam("alg", "HS256").setIssuedAt(date) // 设置签发时间
                .setExpiration(new Date(date.getTime() + 1000 * 60 * 60))
                .claim("userId", String.valueOf(userId)) // 设置内容
                .setIssuer("lws");// 设置签发人
//                .signWith(signatureAlgorithm, "签名"); // 签名，需要算法和key
        String jwt = builder.compact();
        return jwt;
    }

}
