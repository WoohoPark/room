package com.example.room.space.entity.space;

import com.example.room.common.constants.LocationStatus;
import com.example.room.host.entity.Host;
import com.example.room.reservation.entity.Reservation;
import com.example.room.review.entity.Review;
import com.example.room.space.entity.facility.Facility;
import com.example.room.space.entity.rental.Rental;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("partyRoom")
public class SpacePartyRoom extends Space{

    SpacePartyRoom(long id, boolean withDog, int peopleCount, String name, LocationStatus location, BigDecimal latitude, BigDecimal longitude, Date createDate, Date updateDate, Rental rental, Facility facility, Host host, List<Review> reviews, List<Reservation> reservations) {
        super(id, withDog, peopleCount, name, location, latitude, longitude, createDate, updateDate, rental, facility, host, reviews, reservations);
    }
}