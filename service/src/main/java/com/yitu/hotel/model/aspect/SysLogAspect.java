package com.yitu.hotel.model.aspect;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yitu.hotel.mapper.AdminUserMapper;
import com.yitu.hotel.mapper.TokenMapper;
import com.yitu.hotel.entity.adminUser.AdminUser;
import com.yitu.hotel.entity.common.OperationLog;
import com.yitu.hotel.entity.adminUser.Token;
import com.yitu.hotel.service.OperationLogService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.Arrays;


@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private OperationLogService operationLogService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private TokenMapper tokenMapper;

    @Autowired
    private AdminUserMapper adminUserMapper;

    /**
     * 监听每个controller方法
     *
     * @param
     * @return void
     * @author zouhao
     * @date 2020/11/18 18:51
     */
    @Pointcut("execution(public * com.yitu.hotel.controller.*Controller.*(..))")
    public void logPointCut() {
    }

    /**
     * @param point
     * @return java.lang.Object
     * @author zouhao
     * @date 2020/11/18 18:51
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        try {
            saveLog(point);
        } catch (Exception e) {
            System.out.println(e);
        }
        return point.proceed();
    }

    /**
     * 保存日志
     *
     * @param joinPoint
     * @return void
     * @author zouhao
     * @date 2020/11/18 18:52
     */
    private void saveLog(ProceedingJoinPoint joinPoint) throws NoSuchMethodException {
        String token = request.getHeader("Authorization");
        Token tokenBean = null;
        if (StringUtils.isNotBlank(token)) {
            QueryWrapper qw = new QueryWrapper();
            qw.eq("token", token);
            tokenBean = tokenMapper.selectOne(qw);
        }
        String ip = getIpAddress();//ip地址
        Class<?> targetCls = joinPoint.getTarget().getClass();
        RequestMapping annotation = targetCls.getAnnotation(RequestMapping.class);
        String urlHeader = annotation.value()[0];
        //获取方法签名(通过此签名获取目标方法信息)
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        //获取目标方法上的注解指定的操作名称
        Method targetMethod =
                targetCls.getDeclaredMethod(
                        ms.getName(),
                        ms.getParameterTypes());
        RequestMapping targetMethodAnnotation = targetMethod.getAnnotation(RequestMapping.class);
        ApiOperation apiOperation = targetMethod.getAnnotation(ApiOperation.class);
        String name = apiOperation.value();
        String path = targetMethodAnnotation.value()[0];
        String url = urlHeader + "/" + path;
        //获取请求参数
        String targetMethodParams = Arrays.toString(joinPoint.getArgs());
        LocalDateTime requestTime = LocalDateTime.now();
        OperationLog ol = new OperationLog();
        ol.setReqApi(url);
        if (null != tokenBean) {
            String userId = String.valueOf(tokenBean.getUserId());
            AdminUser adminUser = adminUserMapper.selectById(userId);
            ol.setUserId(adminUser.getId());
            ol.setUserName("我是" + adminUser.getUserName());
            ol.setReqApi(url + ",token:" + token);
        }
        ol.setIp(ip);
        ol.setDate(requestTime);
        ol.setReqParams(targetMethodParams);
        ol.setName(name);
        operationLogService.saveLog(ol);
    }

    /**
     * 获取ip地址
     *
     * @param
     * @return java.lang.String
     * @author zouhao
     * @date 2020/11/18 18:52
     */
    private String getIpAddress() {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknow".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();
            }
        }

        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }
}
