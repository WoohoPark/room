package com.example.room.space.dto;

import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SpaceTypeStatus;
import com.example.room.space.entity.space.Space;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class RequestSpace {

    private long id;
    private boolean withDog;
    private int peopleCount;
    private String name;
    private LocationStatus location;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private RentalDto rentalDto;
    private SpaceTypeStatus spaceType;
    private FacilityDto facilityDto;

    @Builder
    public RequestSpace(long id, boolean withDog, int peopleCount, String name,
        LocationStatus location, BigDecimal latitude, BigDecimal longitude,
        SpaceTypeStatus spaceType,
        RentalDto rentalDto, FacilityDto facilityDto) {
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
}
