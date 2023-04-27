package com.example.room.space.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FacilityDto {

    private long id;
    private boolean light;
    private boolean speaker;
    private boolean tableYn;
    private boolean tableware;
    private boolean wifi;
}
