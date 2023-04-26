package com.example.room.space.dto;

import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SpaceTypeStatus;
import com.example.room.fee.dto.FeeDto;
import com.example.room.space.entity.space.Space;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class RequestSpaceDto {

    private long id;
    private boolean withDog;
    private int peopleCount;
    private String name;
    private LocationStatus location;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private RequestRentalDto requestRentalDto;
    private SpaceTypeStatus spaceType;

//    private Re feeDto;

    @Builder
    public RequestSpaceDto(long id, boolean withDog, int peopleCount, String name,
        LocationStatus location, BigDecimal latitude, BigDecimal longitude,
        SpaceTypeStatus spaceType,
        RequestRentalDto requestRentalDto
//        , FeeDto feeDto
    ) {
        this.id = id;
        this.withDog = withDog;
        this.peopleCount = peopleCount;
        this.name = name;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.spaceType = spaceType;
        this.requestRentalDto = requestRentalDto;
//        this.feeDto = feeDto;
    }

    public Space toEntity() {
        return Space.builder()
            .withDog(withDog)
            .peopleCount(peopleCount)
            .name(name)
            .location(location)
            .longitude(longitude)
            .latitude(latitude)
            .spaceType(spaceType)
            .build();
    }

    public RequestRentalDto getRentalDto() {
        return this.requestRentalDto;
    }
}
