package com.example.room.reservation.entity.reservation;

import com.example.room.common.constants.ReservationStateStatus;
import com.example.room.reservation.entity.pay.Pay;
import com.example.room.space.entity.space.Space;
import com.example.room.user.entity.Guest;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "RESERVATION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "reservationType")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 2)
    private int peopleCount;

    @Column(nullable = false, length = 250)
    private String request;

    @Column(length = 250)
    private String message;

    @Column(length = 1)
    private boolean confirmed;

    @Column(length = 6)
    private ReservationStateStatus reservationStateStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date reservationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date responseExpirationDate;

    @ManyToOne
    @JoinColumn(name = "SPACE_ID")
    Space space;

    @OneToOne
    @MapsId
    Pay pay;

    @ManyToOne
    @JoinColumn(name = "GUEST_ID")
    Guest guest;
}
