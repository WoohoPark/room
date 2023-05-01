package com.example.room.reservation.controller;

import com.example.room.common.response.BasicResponse;
import com.example.room.reservation.dto.RequestReservation;
import com.example.room.reservation.entity.Reservation;
import com.example.room.reservation.service.ReservationService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/reservation")
@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    @ApiOperation("예약등록_API")
    public BasicResponse<Reservation> reservation(
        @RequestBody RequestReservation requestReservation) {
        Reservation response = reservationService.reservation(requestReservation);
        return BasicResponse.<Reservation>builder().data(response).build();
    }
}
