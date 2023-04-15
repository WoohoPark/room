package com.example.room.common.constants;

public enum LocationStatus {

    SEOUL(02),
    GYEONGI(031),
    INCHEON(032),
    GANGWON(033),
    BUSAN(052),
    DAEGU(053),
    DAEJEON(042),
    GWANGJU(062),
    JEJU(064);

    private int areaCode;
    LocationStatus(int areaCode) {
        this.areaCode=areaCode;
    }

    public int getAreaCode() {
        return areaCode;
    }
}
