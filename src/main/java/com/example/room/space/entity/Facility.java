package com.example.room.space.entity;

import com.example.room.space.dto.FacilityDto;
import javax.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "FACILITY")
@NoArgsConstructor
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FACILITY_ID")
    private Long id;

    @Column(length = 1)
    private boolean light;

    @Column(length = 1)
    private boolean speaker;

    @Column(length = 1)
    private boolean tableYn;

    @Column(length = 1)
    private boolean tableware;

    @Column(length = 1)
    private boolean wifi;

    @Builder
    public Facility(Long id, boolean light, boolean speaker, boolean tableYn, boolean tableware,
        boolean wifi) {
        this.id = id;
        this.light = light;
        this.speaker = speaker;
        this.tableYn = tableYn;
        this.tableware = tableware;
        this.wifi = wifi;
    }

    public FacilityDto toDto() {
        return FacilityDto.builder()
            .id(id)
            .light(light)
            .speaker(speaker)
            .tableYn(tableYn)
            .tableware(tableware)
            .wifi(wifi)
            .build();
    }
}


