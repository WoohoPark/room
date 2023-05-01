package com.example.room.reservation.entity.reservation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "DEFAULT_RESERVATION")
@DiscriminatorValue("default")
public class DefaultReservation extends Reservation {


}
