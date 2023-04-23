package com.example.room.space.service.impl;

import com.example.room.space.dao.SpaceDAO;
import com.example.room.space.dto.RentalDto;
import com.example.room.space.dto.SpaceDto;
import com.example.room.space.entity.space.Space;
import com.example.room.space.service.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpaceServiceImpl implements SpaceService {
    private final SpaceDAO spaceDAO;
    @Override
    @Transactional
    public SpaceDto create(SpaceDto spaceDto) {
        SpaceDto a= spaceDAO.createSpace(spaceDto);
//        spaceDAO.createRental(rentalDto);
        return a;
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

    @Override
    public RentalDto findRentalById(long id) {
        return spaceDAO.findRentalById(id);
    }
}
