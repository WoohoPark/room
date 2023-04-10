package com.example.room.common.exception;

import com.example.room.common.exception.domain.ErrorResponse;
import com.example.room.common.exception.status.ErrorCodeStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.InvalidParameterException;

@Slf4j
@RestControllerAdvice
public class CommonException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> errorException(Exception e){
        log.error("전체 에러 처리!!!");

        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(500)
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(e.toString())
                .build();

        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<ErrorResponse> invalidParameterException(InvalidParameterException e) {
        log.error("잘못된 값 요청!!!");

        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(ErrorCodeStatus.ALREADY_SAVED_NICKNAME.getStatus())
                .status(HttpStatus.CONFLICT.value())
                .message(ErrorCodeStatus.ALREADY_SAVED_NICKNAME.getMessage())
                .build();

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> UniqueKeyViolationException(DataIntegrityViolationException e) {
        log.error("중복값이 들어 왔음!!!");

        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.LOCKED.value())
                .message(ErrorCodeStatus.ALREADY_SAVED_NICKNAME.getMessage())
                .code(ErrorCodeStatus.ALREADY_SAVED_NICKNAME.getStatus())
                .build();

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
