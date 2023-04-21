package com.example.room.reservation.entity;

import com.example.room.space.entity.fee.Fee;
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
    private String response;

    @Column(length = 1)
    private boolean confirmed;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date reservationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
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
