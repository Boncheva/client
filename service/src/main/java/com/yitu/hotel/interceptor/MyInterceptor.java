package com.yitu.hotel.interceptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yitu.hotel.enums.ResponseCode;
import com.yitu.hotel.mapper.TokenMapper;
import com.yitu.hotel.entity.adminUser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 拦截器，通过验证请求头部是否携带token来用户是否登录，因为拦截器实例化先于ioc，所以此处需要添加@Service注解
 */
@Service
public class MyInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenMapper tokenMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求头部Authorization的信息
        String token = request.getHeader("Authorization");
        //在拦截器中设置允许跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Max-Age", "3600");
        //如果token为空，返回错误代码401（用户未登录）
        if (token == null || "".equals(token)) {
            response.setContentType("application/json");
            response.setHeader("Cache-Control", "no-store");
            response.setCharacterEncoding("UTF-8");
            PrintWriter pw = response.getWriter();
            pw.write(String.valueOf(ResponseCode.UNAUTHORIZED.getCode()));
            pw.flush();
            return false;
        } else {
            //token不为空，验证token是否存在
            QueryWrapper qw = new QueryWrapper();
            qw.eq("token", token);
            Token myToken = tokenMapper.selectOne(qw);
            if (myToken == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}
