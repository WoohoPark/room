package com.example.room.space.entity.rental;

import com.example.room.space.entity.space.Space;

import javax.persistence.*;

@Entity(name = "RENTAL")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RENTAL_ID")
    private long id;

    private boolean partySupplies;

    private boolean backgroundPaper;

    @OneToOne
    @JoinColumn(name = "SPACE_ID")
    private Space space;

}
