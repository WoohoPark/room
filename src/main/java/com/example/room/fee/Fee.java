package com.example.room.fee;

import com.example.room.common.constants.PaymentStatus;
import com.example.room.reservation.entity.Reservation;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "FEE")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "feeType")
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int fee;

    @Temporal(TemporalType.TIMESTAMP)
    private Date payDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus payment;

    @OneToOne(mappedBy = "fee")
    private Reservation reservation;
}
