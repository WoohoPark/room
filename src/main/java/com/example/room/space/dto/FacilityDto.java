package com.example.room.space.dto;

import com.example.room.space.entity.facility.Facility;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FacilityDto {

    private final long id;
    private final boolean light;
    private final boolean speaker;
    private final boolean tableYn;
    private final boolean tableware;
    private final boolean wifi;

    @Builder
    public FacilityDto(long id, boolean light, boolean speaker, boolean tableYn, boolean tableware,
        boolean wifi) {
        this.id = id;
        this.light = light;
        this.speaker = speaker;
        this.tableYn = tableYn;
        this.tableware = tableware;
        this.wifi = wifi;
    }

    public FacilityDto(Facility facility) {
        this.id = facility.getId();
        this.light = facility.isLight();
        this.speaker = facility.isSpeaker();
        this.tableYn = facility.isTableYn();
        this.tableware = facility.isTableware();
        this.wifi = facility.isWifi();
    }

    public Facility toEntity() {
        return Facility.builder()
            .id(id)
            .light(light)
            .speaker(speaker)
            .tableware(tableware)
            .tableYn(tableYn)
            .wifi(wifi)
            .build();
    }
}
