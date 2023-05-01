package com.example.room.space.dto;

import com.example.room.common.constants.FeeTypeStatus;
import com.example.room.common.constants.MorningAfternoonStatus;
import com.example.room.common.constants.PackageStatus;
import com.example.room.space.entity.Fee;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FeeDto {

    private final Long id;
    private final int fee;
    private final FeeTypeStatus feeType;
    private final PackageStatus packageType;
    private final MorningAfternoonStatus morningAfternoon;

    @Builder
    public FeeDto(long id, int fee, FeeTypeStatus feeType, PackageStatus packageType,
        MorningAfternoonStatus morningAfternoon) {
        this.id = id;
        this.fee = fee;
        this.feeType = feeType;
        this.packageType = packageType;
        this.morningAfternoon = morningAfternoon;
    }

    public FeeDto(Fee fee) {
        this.id = fee.getId();
        this.fee = fee.getFee();
        this.feeType = fee.getFeeType();
        this.packageType = fee.getPackageType();
        this.morningAfternoon = fee.getMorningAfternoon();
    }

    public Fee toEntity() {
        return Fee.builder()
            .id(id)
            .fee(fee)
            .feeType(feeType)
            .packageType(packageType)
            .morningAfternoon(morningAfternoon)
            .build();
    }
}