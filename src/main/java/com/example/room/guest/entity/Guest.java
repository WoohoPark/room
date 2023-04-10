package com.example.room.guest.entity;

import com.example.room.reservation.entity.ReservationEntity;
import com.example.room.review.entity.ReviewEntity;
import com.example.room.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity(name = "GUEST")
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "UniqueNickName", columnNames = "nickName")
})
@Getter
@SuperBuilder
@NoArgsConstructor
public class Guest extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GUEST_ID")
    private long  id;

    private long businessNumber;

    @OneToMany(mappedBy = "guest")
    List<ReservationEntity> reservationEntities;

    @OneToMany(mappedBy = "guest")
    List<ReviewEntity> reviewEntities;

}
