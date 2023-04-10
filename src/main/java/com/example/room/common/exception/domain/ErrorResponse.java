package com.example.room.common.exception.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResponse {

    private String message; //예외 메시지 저장

    private int code; // 예외를 세분화하기 위한 사용자 지정 코드,

    private int status; // HTTP 상태 값 저장 400, 404, 500 등..

    //@Valid의 Parameter 검증을 통과하지 못한 필드가 담긴다.
    /*@JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("errors")
    private List<CustomFieldError> customFieldErrors;*/

}
