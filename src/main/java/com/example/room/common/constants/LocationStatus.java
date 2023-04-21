package com.example.room.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

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

    @Getter
    @AllArgsConstructor
    public enum ErrorCodeStatus {

        //400 잘못된 요청
        INVALID_PARAMETER(400, "요청 값을 확인해주세요."),

        //404 잘못된 리소스 접근
        DISPLAY_NOT_FOUND(404, "비정상적인 요청입니다."),
        SAVED_FESTIVAL_NOT_FOUND(404, "저장되지 않은 공간입니다."),

        //409 중복된 리소스
        ALREADY_SAVED_NICKNAME(409, "이미 저장된 닉네임입니다."),

        //500 SERVER ERROR
        INTERNAL_SERVER_ERROR(500, "서비스에 에러가 발생하였습니다."),
        NO_STORE_DATA(500, "존재 하지 않는 값 입니다.");

        private final int status;
        private final String message;
    }
}
