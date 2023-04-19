package com.example.room.guest.entity;

import com.example.room.reservation.entity.Reservation;
import com.example.room.review.entity.Review;
import com.example.room.user.entity.User;
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
