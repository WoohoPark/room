package com.example.room.space.dto;

import com.example.room.space.entity.rental.Rental;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseRentalDto {

    private long id;
    private boolean partySupplies;
    private boolean backgroundPaper;

    @Builder
    public ResponseRentalDto(long id, boolean partySupplies, boolean backgroundPaper) {
        this.id = id;
        this.partySupplies = partySupplies;
        this.backgroundPaper = backgroundPaper;
    }

    public Rental toEntity() {
        return Rental.builder()
            .id(id)
            .partySupplies(partySupplies)
            .backgroundPaper(backgroundPaper)
            .build();
    }
}
