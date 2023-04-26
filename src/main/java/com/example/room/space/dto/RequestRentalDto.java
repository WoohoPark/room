package com.example.room.space.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestRentalDto {

    private long id;
    private boolean partySupplies;
    private boolean backgroundPaper;
}