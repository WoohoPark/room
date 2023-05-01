package com.example.room.reservation.service;

import com.example.room.reservation.dto.RequestReservation;
import com.example.room.reservation.entity.Reservation;

public interface ReservationService {

    boolean isHoldReservationBySpaceId(Long id);

    Reservation reservation(RequestReservation requestReservation);
}
