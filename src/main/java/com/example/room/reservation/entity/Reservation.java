package com.example.room.reservation.entity;

import com.example.room.space.entity.fee.Fee;
import com.example.room.guest.entity.Guest;
import com.example.room.space.entity.space.Space;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "RESERVATION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "reservationType")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int peopleCount;

    private String request;

    private String response;

    private boolean confirmed;

    @Temporal(TemporalType.TIMESTAMP)
    private Date reservationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date responseDate;

    @ManyToOne
    @JoinColumn(name = "SPACE_ID")
    Space space;

    @OneToOne
    @JoinColumn(name = "FEE_ID")
    Fee fee;

    @ManyToOne
    @JoinColumn(name = "GUEST_ID")
    Guest guest;
}
