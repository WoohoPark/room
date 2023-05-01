package com.example.room.reservation.entity.pay;

import com.example.room.common.constants.PaymentStatus;
import com.example.room.reservation.entity.reservation.Reservation;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date payDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus payment;
//
//    @OneToOne(mappedBy = "fee")
//    private Reservation reservation;
}
