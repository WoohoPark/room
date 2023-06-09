package com.example.room.common.exception;

import com.example.room.common.constants.ErrorResponseStatus;
import com.example.room.common.response.BasicResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CommonException {

//    @ExceptionHandler(RuntimeException.class)
//    public BasicResponse<?> handlerException(final RuntimeException error) {
//        return BasicResponse.builder()
//            .status(HttpStatus.SERVICE_UNAVAILABLE.value())
//            .message(error.getMessage())
//            .build();
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> errorException(Exception e){
//        log.error("전체 에러 처리!!!");
//
//        ErrorResponse errorResponse = ErrorResponse.builder()
//                .code(HttpStatus.BAD_GATEWAY.value())
//                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
//                .message(e.toString())
//                .build();
//
//        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(InvalidParameterException.class)
//    public ResponseEntity<ErrorResponse> invalidParameterException() {
//        log.error("잘못된 값 요청!!!");
//
//        ErrorResponse errorResponse = ErrorResponse.builder()
//                .code(ErrorCodeStatus.ALREADY_SAVED_NICKNAME.getStatus())
//                .status(HttpStatus.CONFLICT.value())
//                .message(ErrorCodeStatus.ALREADY_SAVED_NICKNAME.getMessage())
//                .build();
//
//        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public BasicResponse<?> uniqueKeyViolationException() {
        log.error("DB UNIQUE KEY DUPLICATION");
        return BasicResponse.builder()
            .status(ErrorResponseStatus.ALREADY_SAVED_NICKNAME.getStatus())
            .message(ErrorResponseStatus.ALREADY_SAVED_NICKNAME.getMessage())
            .build();
    }
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    public BasicResponse<?> argumentException() {
//        log.error("BAD ARGUMENT");
//        return BasicResponse.builder()
//            .status(ErrorResponseStatus.ALREADY_SAVED_NICKNAME.getStatus())
//            .message(ErrorResponseStatus.ALREADY_SAVED_NICKNAME.getMessage())
//            .build();
//    }
//
//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<ErrorResponse> nullPointException() {
//        log.error("존재하지 않는 값!!!");
//
//        ErrorResponse errorResponse = ErrorResponse.builder()
//                .status(HttpStatus.LOCKED.value())
//                .message(ErrorCodeStatus.NO_STORE_DATA.getMessage())
//                .code(ErrorCodeStatus.NO_STORE_DATA.getStatus())
//                .build();
//
//        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorResponse> argumentValidException(BindingResult e) {
//        log.error("입력값이 올바르지 않음.!!!");
//
//        String message = e.getAllErrors()
//                                    .stream()
//                                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                                    .collect(Collectors.joining(","));
//
//        ErrorResponse errorResponse = ErrorResponse.builder()
//                .status(HttpStatus.BAD_REQUEST.value())
//                .message(message)
//                .code(ErrorCodeStatus.INVALID_PARAMETER.getStatus())
//                .build();
//
//        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
//    }

}
