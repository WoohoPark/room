package com.example.room.user.entity;

import com.example.room.reservation.entity.Reservation;
import com.example.room.review.entity.Review;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity(name = "GUEST")
@Getter
@SuperBuilder
@NoArgsConstructor
@DiscriminatorValue("guest")
public class Guest extends User {

    private LocalDate birthDate;

//    @OneToMany(mappedBy = "guest")
//    List<Reservation> reservations;

    @OneToMany(mappedBy = "guest")
    List<Review> reviews;
}
