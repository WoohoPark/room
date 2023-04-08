package com.example.room.fee.entity;

import com.example.room.fee.domain.PaymentStatus;

import javax.persistence.*;

@Entity(name = "FEE")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "feeType")
public class FeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int fee;

    @Enumerated(EnumType.STRING)
    private PaymentStatus payment;

}
