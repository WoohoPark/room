package com.example.room.host.entity;

import com.example.room.space.entity.SpaceEntity;
import com.example.room.user.domain.User;

import javax.persistence.*;
import java.util.List;

@Entity(name = "HOST")
public class HostEntity extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOST_ID")
    private Long id;

    @OneToMany(mappedBy = "hostEntity")
    private List<SpaceEntity> spaceEntities;

}
