package com.example.room.space.dto;

import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SpaceTypeStatus;
import com.example.room.space.entity.Space;
import com.example.room.user.entity.User;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class RequestSpace {

    private Long id;
    private Long userNo;
    private boolean withDog;
    private int peopleCount;
    private String name;
    private LocationStatus location;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private RentalDto rentalDto;
    private SpaceTypeStatus spaceType;
    private FacilityDto facilityDto;
    private FeeDto feeDto;

    @Builder
    public RequestSpace(Long id, Long userNo, boolean withDog, int peopleCount, String name,
        LocationStatus location, BigDecimal latitude, BigDecimal longitude,
        SpaceTypeStatus spaceType,
        RentalDto rentalDto, FacilityDto facilityDto, FeeDto feeDto) {
        this.id = id;
        this.withDog = withDog;
        this.peopleCount = peopleCount;
        this.name = name;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.spaceType = spaceType;
        this.rentalDto = rentalDto;
        this.facilityDto = facilityDto;
        this.feeDto = feeDto;
    }

    public Space toEntity(User user) {
        return Space.builder()
            .withDog(withDog)
            .peopleCount(peopleCount)
            .name(name)
            .location(location)
            .longitude(longitude)
            .latitude(latitude)
            .spaceType(spaceType)
            .facility(facilityDto.toEntity())
            .rental(rentalDto.toEntity())
            .fee(feeDto.toEntity())
            .user(user)
            .build();
    }
}
