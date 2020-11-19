package com.yitu.hotel.enums;

public enum orderStatusCode {
    _0_(0, "预订待审核"),
    _1_(1, "审核未通过"),
    _2_(2, "已预订"),
    _3_(3, "入住"),
    _4_(4, "爽约"),
    _5_(5, "退房"),
    _9_(9, "取消");

    private final int code;
    private final String status;

    orderStatusCode(int code, String status) {
        this.code = code;
        this.status = status;
    }

    public static String getStatus(int code) {
        orderStatusCode[] orderStatusCodes = orderStatusCode.values();
        for (int i = 0; i < orderStatusCodes.length; i++) {
            if (orderStatusCodes[i].code == code) {
                return orderStatusCodes[i].status;
            }
        }
        return null;
    }
}
