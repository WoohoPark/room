package com.example.room.space.dto;

import com.example.room.common.constants.LocationStatus;
import com.example.room.fee.dto.FeeDto;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseSpaceDto {

    private long id;
    private boolean withDog;
    private int peopleCount;
    private String name;
    private LocationStatus location;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Date createDate;
    private Date updateDate;
    private ResponseRentalDto rentalDto;
    private FeeDto feeDto;
}
