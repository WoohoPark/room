package com.example.room.space.dto;

import com.example.room.common.constants.LocationStatus;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class SpaceDto {

    private long id;
    private boolean withDog;
    private int peopleCount;
    private String name;
    private LocationStatus location;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Date createDate;
    private Date updateDate;
    private RentalDto rentalDto;
    private FeeDto feeDto;

    @Builder
    public SpaceDto(long id, boolean withDog, int peopleCount, String name, LocationStatus location,
        BigDecimal latitude, BigDecimal longitude, Date createDate, Date updateDate,
        RentalDto rentalDto, FeeDto feeDto) {
        this.id = id;
        this.withDog = withDog;
        this.peopleCount = peopleCount;
        this.name = name;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.rentalDto = rentalDto;
        this.feeDto = feeDto;
    }
}
