package com.example.room.reservation.service.impl;

import com.example.room.reservation.dto.RequestReservation;
import com.example.room.reservation.entity.Reservation;
import com.example.room.reservation.repository.ReservationRepository;
import com.example.room.reservation.service.ReservationService;
import com.example.room.space.entity.Space;
import com.example.room.space.service.SpaceService;
import com.example.room.user.entity.Guest;
import com.example.room.user.entity.User;
import com.example.room.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final PayService payService;
    private final SpaceService spaceService;
    private final UserService userService;

    @Override
    public boolean isHoldReservationBySpaceId(Long id) {
        return true;
    }

    @Override
    public Reservation reservation(RequestReservation requestReservation) {

        //Todo 인원/날짜/계산값/Validation/TestCode
        payService.totalPayCalculator(requestReservation);
        Space space = spaceService.findSpaceInfoBySpaceId(requestReservation.getSpaceId());
        User user = userService.findByUserNo(requestReservation.getUserNo());
        Reservation reservation = reservationRepository.save(
            requestReservation.toEntity(space, user));
        return reservation;
    }
}
