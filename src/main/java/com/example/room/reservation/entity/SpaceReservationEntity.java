package com.example.room.reservation.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "SPACE_RESERVATION")
@DiscriminatorValue("default")
public class SpaceReservationEntity extends ReservationEntity {


}
