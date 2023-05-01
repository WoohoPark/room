package com.example.room.reservation.service.impl;

import com.example.room.common.constants.FeeTypeStatus;
import com.example.room.reservation.dto.RequestReservation;
import com.example.room.util.DateUtil;
import org.springframework.stereotype.Service;

@Service
public class PayService {

    public void totalPayCalculator(RequestReservation requestReservation) {
        calculator(requestReservation);
    }

    private void calculator(RequestReservation requestReservation) {
        calculatorByFeeStrategy(requestReservation);
        calculatorByDayReservation(requestReservation);
    }

    private void calculatorByFeeStrategy(RequestReservation requestReservation) {
        if (FeeTypeStatus.isPackageFeeCode(requestReservation.getFeeDto().getFeeType())) {
            feePackageCalculator(requestReservation);
            return;
        }
        feeTimeCalculator(requestReservation);
        return;
    }

    private void feePackageCalculator(RequestReservation requestReservation) {
        requestReservation.getPayDto().setTotalPay(
            FeeTypeStatus.PACKAGE.calculator(requestReservation.getFeeDto().getFee()));
    }

    private void feeTimeCalculator(RequestReservation requestReservation) {
        requestReservation.getPayDto().setTotalPay(
            FeeTypeStatus.TIME.calculator(requestReservation.getFeeDto().getFee(),
                requestReservation.getTime(),
                requestReservation.getFeeDto().getMorningAfternoon().getPremium()));
    }

    private void calculatorByDayReservation(RequestReservation requestReservation) {
        if (DateUtil.isToday(requestReservation.getReservationDate())) {
            requestReservation.getPayDto()
                .setTotalPay(
                    Math.floor(requestReservation.getPayDto().getTotalPay() * 0.5 * 100) / 100);
        }
    }
}
