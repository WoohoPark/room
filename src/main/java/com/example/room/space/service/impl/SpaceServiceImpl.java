package com.example.room.space.service.impl;

import com.example.room.space.dao.SpaceDAO;
import com.example.room.space.dto.SpaceDto;
import com.example.room.space.entity.space.Space;
import com.example.room.space.service.SpaceService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpaceServiceImpl implements SpaceService {

    private final SpaceDAO spaceDAO;


    @Override
    public SpaceDto create(SpaceDto spaceDto) {
        System.out.println(spaceDto);
        Space space = spaceDAO.create(spaceDto);
        return null;
    }

    @Override
    public List<Space> getSpaces() {
        return null;
    }

    @Override
    public Space update() {
        return null;
    }

    @Override
    public void delete() {

    }
}
