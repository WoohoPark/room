package com.example.room.space.entity.fee;

import com.example.room.common.constants.MorningAfternoonStatus;

import javax.persistence.*;

@Entity(name = "FEE_TIME")
@DiscriminatorValue("time")
public class FeeTime extends Fee {

    @Id
    @GeneratedValue
    @Column(name = "FEE_TIME_ID")
    private long id;

    private MorningAfternoonStatus morningAfternoon;

    private int times;
}
