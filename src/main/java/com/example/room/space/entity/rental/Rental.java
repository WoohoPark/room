package com.example.room.space.entity.rental;

import com.example.room.space.dto.RentalDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity(name = "RENTAL")
@NoArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RENTAL_ID")
    private long id;

    @Column(length = 1)
    private boolean partySupplies;

    @Column(length = 1)
    private boolean backgroundPaper;

    @Builder
    public Rental(long id, boolean partySupplies, boolean backgroundPaper) {
        this.id = id;
        this.partySupplies = partySupplies;
        this.backgroundPaper = backgroundPaper;
    }

    public RentalDto toDto() {
        return RentalDto.builder()
            .id(id)
            .partySupplies(partySupplies)
            .backgroundPaper(backgroundPaper)
            .build();
    }
}
