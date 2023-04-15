package com.example.room.host.entity;

import com.example.room.space.entity.space.Space;
import com.example.room.user.entity.User;

import javax.persistence.*;
import java.util.List;

@Entity(name = "HOST")
public class Host extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOST_ID")
    private Long id;

    @OneToMany(mappedBy = "host")
    private List<Space> spaces;

    private long businessNumber;

}
