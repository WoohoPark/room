package com.example.room.reservation.entity;

import com.example.room.common.constants.PaymentStatus;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Pay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double totalPay;

    private LocalDate payDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus payment;

    @Builder
    public Pay(Long id, double totalPay, LocalDate payDate, PaymentStatus payment) {
        this.id = id;
        this.totalPay = totalPay;
        this.payDate = payDate;
        this.payment = payment;
    }
}
