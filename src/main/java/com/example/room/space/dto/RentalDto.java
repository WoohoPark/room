package com.example.room.space.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class RentalDto {
    private long id;
    private boolean partySupplies;
    private boolean backgroundPaper;

    @Builder
    public RentalDto(long id, boolean partySupplies, boolean backgroundPaper) {
        this.id = id;
        this.partySupplies = partySupplies;
        this.backgroundPaper = backgroundPaper;
    }
}
