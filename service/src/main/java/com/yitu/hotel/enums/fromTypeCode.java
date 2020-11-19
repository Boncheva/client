package com.yitu.hotel.enums;

public enum fromTypeCode {
    _0_(0, "用户"),
    _1_(1, "酒店"),
    _2_(2, "导入"),
    ;

    //来源：0用户、1酒店、2导入',
    private final int code;
    private final String type;

    fromTypeCode(int code, String type) {
        this.code = code;
        this.type = type;
    }

    public static String getFromType(int code) {
        fromTypeCode[] fromTypeCodes = fromTypeCode.values();
        for (int i = 0; i < fromTypeCodes.length; i++) {
            if (fromTypeCodes[i].code == code) {
                return fromTypeCodes[i].type;
            }
        }
        return null;
    }
}
