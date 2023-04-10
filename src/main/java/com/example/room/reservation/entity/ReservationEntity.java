package com.example.room.reservation.entity;

import com.example.room.guest.entity.Guest;
import com.example.room.space.entity.SpaceEntity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "RESERVATION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "reservationType")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int peopleCount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String request;

    @ManyToOne
    @JoinColumn(name = "SPACE_ID")
    SpaceEntity spaceEntity;

    @ManyToOne
    @JoinColumn(name = "GUEST_ID")
    Guest guest;
}
