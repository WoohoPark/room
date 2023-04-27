package com.example.room.space.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RentalDto {

    private long id;
    private boolean partySupplies;
    private boolean backgroundPaper;
}
