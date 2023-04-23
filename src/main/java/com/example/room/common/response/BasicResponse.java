package com.example.room.common.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BasicResponse<T> {
    private final int status;
    private final T data;
    private final String message;

    @Builder
    public BasicResponse(int status, T data, String message) {
        this.status = (status == 0 ? 200 : status);
        this.data = data;
        this.message = (message == null ? "success" : message);
    }
}
