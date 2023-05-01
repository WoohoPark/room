package com.example.room.reservation.entity;

import com.example.room.common.constants.ReservationStateStatus;
import com.example.room.space.entity.Space;

import com.example.room.user.entity.User;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "RESERVATION")
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "RESERVATION_ID")
    private Long id;

    @Column(nullable = false, length = 2)
    private int peopleCount;

    @Column(nullable = false, length = 2)
    private int time;

    @Column(nullable = false, length = 250)
    private String requestMessage;

    @Column(length = 250)
    private String responseMessage;

    @Column(length = 6)
    private ReservationStateStatus reservationStateStatus;

    @Column(nullable = false, updatable = false)
    private LocalDate reservationDate;

    @Column(nullable = false, updatable = false)
    private LocalDate responseExpirationDate;

    @ManyToOne
    @JoinColumn(name = "SPACE_ID")
    Space space;

    @OneToOne
    @MapsId
    Pay pay;

    @ManyToOne
    @JoinColumn(name = "USER_NO")
    User user;

    @PrePersist
    private void onCreate() {
        reservationDate = LocalDate.now();
        responseExpirationDate = LocalDate.now().plusDays(3L);

    }

    @Builder
    public Reservation(long id, int peopleCount, int time, String requestMessage,
        String responseMessage, ReservationStateStatus reservationStateStatus,
        LocalDate reservationDate, LocalDate responseExpirationDate, Space space, Pay pay,
        User user) {
        this.id = id;
        this.peopleCount = peopleCount;
        this.time = time;
        this.requestMessage = requestMessage;
        this.responseMessage = responseMessage;
        this.reservationStateStatus = reservationStateStatus;
        this.reservationDate = reservationDate;
        this.responseExpirationDate = responseExpirationDate;
        this.space = space;
        this.pay = pay;
        this.user = user;
    }
}
