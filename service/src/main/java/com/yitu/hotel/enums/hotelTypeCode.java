package com.yitu.hotel.enums;

public enum hotelTypeCode {
    _1006_("1006", "香港入境及其它入境人员隔离酒店"),
    _1007_("1007", "跨境豁免司机隔离酒店"),
    _1008_("1008", "国际航班入境人员隔离酒店"),
    _1009_("1009", "经深圳转运到市外人员隔离酒店"),
    _1010_("1010", "境外航班机组人员隔离酒店"),
    _1011_("1011", "密切接触者隔离酒店"),
    _1012_("1012", "医院隔离病房");

    private final String code;
    private final String type;

    hotelTypeCode(String code, String type) {
        this.code = code;
        this.type = type;
    }

    public static String getType(String code) {
        hotelTypeCode[] hotelTypeCodes = hotelTypeCode.values();
        for (int i = 0; i < hotelTypeCodes.length; i++) {
            if (code.equals(hotelTypeCodes[i].code)) {
                return hotelTypeCodes[i].type;
            }
        }
        return null;
    }
}
