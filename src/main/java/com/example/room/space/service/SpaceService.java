package com.example.room.space.service;

import com.example.room.space.dto.RentalDto;
import com.example.room.space.dto.SpaceDto;

public interface SpaceService {

    SpaceDto create(SpaceDto spaceDto);

    RentalDto findRentalById(long id);
}
