package com.example.room.space.service;

import com.example.room.space.dto.SpaceDto;
import com.example.room.space.entity.space.Space;

import java.util.List;

public interface SpaceService {

    SpaceDto create(SpaceDto spaceDto);

    List<Space> getSpaces();

    Space update();

    void delete();
}
