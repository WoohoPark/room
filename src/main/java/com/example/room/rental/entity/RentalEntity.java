package com.example.room.rental.entity;

import com.example.room.space.entity.SpaceEntity;

import javax.persistence.*;

@Entity(name = "RENTAL")
public class RentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RENTAL_ID")
    private long id;

    @OneToOne
    @JoinColumn(name = "SPACE_ID")
    private SpaceEntity spaceEntity;

}
