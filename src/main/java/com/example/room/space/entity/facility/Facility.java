package com.example.room.space.entity.facility;

import com.example.room.space.entity.space.Space;

import javax.persistence.*;

@Entity(name = "FACILITY")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FACILITY_ID")
    private long id;

    @Column(length = 1)
    private boolean light;

    @Column(length = 1)
    private boolean speaker;

    @Column(length = 1)
    private boolean tableYn;

    @Column(length = 1)
    private boolean tableware;

    @Column(length = 1)
    private boolean wifi;

    @OneToOne
    @JoinColumn(name = "SPACE_ID")
    private Space space;

}
