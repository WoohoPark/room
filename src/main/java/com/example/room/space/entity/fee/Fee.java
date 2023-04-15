package com.example.room.space.entity.fee;

import com.example.room.common.constants.PaymentStatus;
import com.example.room.reservation.entity.Reservation;

import javax.persistence.*;

@Entity(name = "FEE")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "feeType")
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int fee;

    @Enumerated(EnumType.STRING)
    private PaymentStatus payment;

    @OneToOne(mappedBy = "fee")
    private Reservation reservation;
}
