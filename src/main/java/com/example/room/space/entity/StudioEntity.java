package com.example.room.space.entity;


import javax.persistence.*;

@Entity
@DiscriminatorValue("studio")
public class StudioEntity extends SpaceEntity {

    @Id
    @GeneratedValue
    @Column(name = "STUDIO_ID")
    private long id;
}
