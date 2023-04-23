package com.example.room.space.dao;

import com.example.room.space.dto.RentalDto;
import com.example.room.space.dto.SpaceDto;
import com.example.room.space.entity.space.Space;

import java.util.List;

public interface SpaceDAO {

//    SpaceDto create(SpaceDto spaceDto);

    List<Space> getSpaces();

    SpaceDto getSpace();
    Space update();

    void delete();

    RentalDto findRentalById(long id);

    long createRental(RentalDto rentalDto);

    SpaceDto createSpace(SpaceDto spaceDto);
}
