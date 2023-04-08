package com.example.room.facility.entity;

import com.example.room.space.entity.SpaceEntity;

import javax.persistence.*;

@Entity(name = "FACILITY")
public class FacilityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FACILITY_ID")
    private long id;

    @OneToOne
    @JoinColumn(name = "SPACE_ID")
    private SpaceEntity spaceEntity;

}
