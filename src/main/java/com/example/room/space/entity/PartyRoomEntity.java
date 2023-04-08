package com.example.room.space.entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("party")
public class PartyRoomEntity extends SpaceEntity{

    @Id
    @GeneratedValue
    @Column(name = "PARTY_ROOM_ID")
    private long id;

}