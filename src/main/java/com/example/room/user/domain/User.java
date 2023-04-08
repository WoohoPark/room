package com.example.room.user.domain;

import com.example.room.user.domain.SexualStatus;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
public abstract class User {

    @Column(nullable = false)
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SexualStatus sexual;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickName;
}
