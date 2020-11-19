package com.yitu.hotel.exception;

import com.yitu.hotel.model.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/18
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    // 专用的错误日志收集器
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 自定义异常
     *
     * @param e
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 19:34
     */
    @ResponseBody
    @ExceptionHandler({CustomException.class})
    public JsonResult handleTestException(CustomException e) {
        log.error(e.getMessage(), e);
        return JsonResult.fail(e.getMessage());
    }

}
