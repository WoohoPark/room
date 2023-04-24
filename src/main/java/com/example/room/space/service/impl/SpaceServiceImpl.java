package com.example.room.space.service.impl;

import com.example.room.space.dto.RentalDto;
import com.example.room.space.dto.SpaceDto;
import com.example.room.space.entity.rental.Rental;
import com.example.room.space.entity.space.Space;
import com.example.room.space.mapper.SpaceMapper;
import com.example.room.space.repository.SpaceRepository;
import com.example.room.space.service.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SpaceServiceImpl implements SpaceService {

    private final SpaceRepository spaceRepository;

    private final SpaceMapper spaceMapper;

    @Override
    @Transactional
    public SpaceDto create(SpaceDto spaceDto) {
        Space paramEntity = spaceMapper.convertSpaceEntity(spaceDto);
        Space resultEntity = spaceRepository.save(paramEntity);
        return spaceMapper.convertSpaceDto(resultEntity);
    }

    @Override
    public RentalDto findRentalById(long id) {
        Space space = spaceRepository.findSpaceById(id);
        Rental rental = space.getRental();
        return spaceMapper.convertRentalDto(rental);
    }
}
