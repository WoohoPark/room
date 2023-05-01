package com.example.room.reservation.entity.reservation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "DAY_RESERVATION")
@DiscriminatorValue("day")
public class DayReservation extends Reservation {

}
