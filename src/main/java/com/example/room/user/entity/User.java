package com.example.room.user.entity;

import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SexualStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Getter
@SuperBuilder
@MappedSuperclass
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

    @Enumerated(EnumType.STRING)
    private LocationStatus location;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

}
