package com.yitu.hotel.enums;

public enum houseTypeCode {
    _1_(1, "普通房间"),
    _2_(2, "货车司机专用"),
    _3_(3, "其他");

    private final int code;
    private final String type;

    houseTypeCode(int code, String type) {
        this.code = code;
        this.type = type;
    }

    public static String getType(int code) {
        houseTypeCode[] values = houseTypeCode.values();
        for (int i = 0; i < values.length; i++) {
            if (values[i].code == code) {
                return values[i].type;
            }
        }
        return null;
    }
}
