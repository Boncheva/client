package com.yitu.hotel.enums;

/**
 * @Description: 响应码枚举
 */
public enum ResponseCode {
    /** 成功 */
    OK(200, "成功"),
    /** 用户身份认证失败 */
    UNAUTHORIZED(401, "用户身份认证失败"),
    /** 没有权限 */
    NOT_PERMISSION(402, "没有权限"),
    /** 服务器内部错误 */
    INTERNAL_SERVER_ERROR(500, "服务器内部错误");

    private final int code;
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
