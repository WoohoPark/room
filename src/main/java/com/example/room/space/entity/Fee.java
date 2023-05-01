package com.example.room.space.entity;

import com.example.room.common.constants.FeeTypeStatus;
import com.example.room.common.constants.MorningAfternoonStatus;
import com.example.room.common.constants.PackageStatus;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Fee {

    @Id
    @Column(name = "FEE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int fee;

    @Enumerated(EnumType.STRING)
    private FeeTypeStatus feeType;

    @Enumerated(EnumType.STRING)
    private PackageStatus packageType;

    @Enumerated(EnumType.STRING)
    private MorningAfternoonStatus morningAfternoon;

    @Builder
    public Fee(Long id, int fee, FeeTypeStatus feeType, PackageStatus packageType,
        MorningAfternoonStatus morningAfternoon) {
        this.id = id;
        this.fee = fee;
        this.feeType = feeType;
        this.packageType = packageType;
        this.morningAfternoon = morningAfternoon;
    }
}

