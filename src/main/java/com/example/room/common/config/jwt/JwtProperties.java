package com.example.room.common.config.jwt;

public interface JwtProperties {
    String SECRET = "562d5b8be9e980dd6b7e2018335e21bdd0b359ab8c6df43bebaf513d448e2defe02483648a6164816ff98254037c8af569e2d678e06ce2d00b01b645619a58ea"; // 우리 서버만 알고 있는 비밀값
    long EXPIRED_TIME = (60 * 1000L) *10;
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_NAME = "Authorization";
    String LOGIN_URL = "/guest/login";
}
