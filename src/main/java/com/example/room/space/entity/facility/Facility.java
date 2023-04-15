package com.example.room.space.entity.facility;

import com.example.room.space.entity.space.Space;

import javax.persistence.*;

@Entity(name = "FACILITY")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FACILITY_ID")
    private long id;

    @Column
    private boolean light;

    @Column
    private boolean speaker;

    @Column
    private boolean tableYn;

    @Column
    private boolean tableware;

    @Column
    private boolean wifi;

    @OneToOne
    @JoinColumn(name = "SPACE_ID")
    private Space space;

}
