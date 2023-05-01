package com.example.room.space.service.strategy;

import com.example.room.common.constants.FeeTypeStatus;
import com.example.room.reservation.dto.RequestReservation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FeeTimeStrategy implements FeeStrategy {

    private final RequestReservation requestReservation;

    @Override
    public void calculator() {
        requestReservation.getPayDto().setTotalPay(
            FeeTypeStatus.TIME.calculator(requestReservation.getFeeDto().getFee(),
                requestReservation.getTime(),
                requestReservation.getFeeDto().getMorningAfternoon().getPremium()));
    }
}
