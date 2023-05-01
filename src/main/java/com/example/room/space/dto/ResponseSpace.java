package com.example.room.space.dto;

import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SpaceTypeStatus;
import com.example.room.space.entity.Space;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseSpace {

    private final Long id;
    private final boolean withDog;
    private final int peopleCount;
    private final SpaceTypeStatus spaceType;
    private final String name;
    private final LocationStatus location;
    private final BigDecimal latitude;
    private final BigDecimal longitude;
    private final Date createDate;
    private final Date updateDate;
    private final RentalDto rentalDto;
    private final FacilityDto facilityDto;
    private final FeeDto feeDto;

    @Builder
    public ResponseSpace(long id, boolean withDog, int peopleCount, SpaceTypeStatus spaceType,
        String name,
        LocationStatus location, BigDecimal latitude, BigDecimal longitude, Date createDate,
        Date updateDate, RentalDto rentalDto, FacilityDto facilityDto
        , FeeDto feeDto
    ) {
        this.id = id;
        this.withDog = withDog;
        this.peopleCount = peopleCount;
        this.spaceType = spaceType;
        this.name = name;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.rentalDto = rentalDto;
        this.facilityDto = facilityDto;
        this.feeDto = feeDto;
    }

    public ResponseSpace(Space space) {
        this.id = space.getId();
        this.withDog = space.isWithDog();
        this.peopleCount = space.getPeopleCount();
        this.name = space.getName();
        this.spaceType = space.getSpaceType();
        this.location = space.getLocation();
        this.latitude = space.getLatitude();
        this.longitude = space.getLongitude();
        this.createDate = space.getCreateDate();
        this.updateDate = space.getUpdateDate();
        this.rentalDto = new RentalDto(space.getRental());
        this.facilityDto = new FacilityDto(space.getFacility());
        this.feeDto = new FeeDto(space.getFee());
    }
}
