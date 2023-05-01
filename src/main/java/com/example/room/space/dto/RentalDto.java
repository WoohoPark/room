package com.example.room.space.dto;

import com.example.room.space.entity.rental.Rental;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RentalDto {

    private final long id;
    private final boolean partySupplies;
    private final boolean backgroundPaper;

    @Builder
    public RentalDto(long id, boolean partySupplies, boolean backgroundPaper) {
        this.id = id;
        this.partySupplies = partySupplies;
        this.backgroundPaper = backgroundPaper;
    }

    public RentalDto(Rental rental) {
        this.id = rental.getId();
        this.partySupplies = rental.isPartySupplies();
        this.backgroundPaper = rental.isBackgroundPaper();
    }

    public Rental toEntity() {
        return Rental.builder()
            .id(id)
            .partySupplies(partySupplies)
            .backgroundPaper(backgroundPaper)
            .build();
    }
}
