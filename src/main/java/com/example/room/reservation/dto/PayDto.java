package com.example.room.reservation.dto;

import com.example.room.common.constants.PaymentStatus;
import com.example.room.reservation.entity.Pay;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class PayDto {

    private double totalPay;
    private LocalDate payDate;
    private PaymentStatus payment;

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    public Pay toEntity() {
        return Pay.builder()
            .totalPay(totalPay)
            .payment(payment)
            .payDate(payDate)
            .build();
    }
}
