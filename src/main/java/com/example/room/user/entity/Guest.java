package com.example.room.user.entity;

import com.example.room.reservation.entity.reservation.Reservation;
import com.example.room.review.entity.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "GUEST")
@Getter
@SuperBuilder
@NoArgsConstructor
@DiscriminatorValue("guest")
public class Guest extends User {

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    @OneToMany(mappedBy = "guest")
    List<Reservation> reservations;

    @OneToMany(mappedBy = "guest")
    List<Review> reviews;

}
