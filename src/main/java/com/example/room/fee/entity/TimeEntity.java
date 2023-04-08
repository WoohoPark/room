package com.example.room.fee.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "TIME")
@DiscriminatorValue("time")
public class TimeEntity extends FeeEntity {

    private String morningAfternoon;

    private int times;
}
