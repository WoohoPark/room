package com.example.room.reservation.dto;

import com.example.room.reservation.entity.Reservation;
import com.example.room.space.dto.FeeDto;
import com.example.room.space.entity.Space;
import com.example.room.user.entity.Guest;
import com.example.room.user.entity.User;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RequestReservation {

    private Long spaceId;
    private Long userNo;
    private int peopleCount;
    private int time;
    private String requestMessage;
    private LocalDate reservationDate;
    private FeeDto feeDto;
    private PayDto payDto;

    public Reservation toEntity(Space space, User user) {
        return Reservation.builder()
            .peopleCount(peopleCount)
            .time(time)
            .requestMessage(requestMessage)
            .space(space)
            .user(user)
            .pay(payDto.toEntity())
            .build();
    }

    @Builder
    public RequestReservation(Long spaceId, int peopleCount, int time, String requestMessage,
        LocalDate reservationDate, LocalDate responseExpirationDate, FeeDto feeDto, PayDto payDto) {
        this.spaceId = spaceId;
        this.peopleCount = peopleCount;
        this.time = time;
        this.requestMessage = requestMessage;
        this.reservationDate = reservationDate;
        this.feeDto = feeDto;
        this.payDto = payDto;
    }
}
