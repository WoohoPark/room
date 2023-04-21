package com.example.room.space.dto;

import com.example.room.common.constants.PaymentStatus;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class FeeDto {
    private long id;
    private int fee;
    private Date payDate;
    private PaymentStatus paymentStatus;

    @Builder
    public FeeDto(long id, int fee, Date payDate, PaymentStatus paymentStatus) {
        this.id = id;
        this.fee = fee;
        this.payDate = payDate;
        this.paymentStatus = paymentStatus;
    }
}
