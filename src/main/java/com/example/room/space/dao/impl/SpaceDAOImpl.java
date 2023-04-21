package com.example.room.space.dao.impl;

import com.example.room.space.dao.SpaceDAO;
import com.example.room.space.dto.SpaceDto;
import com.example.room.space.entity.space.Space;
import com.example.room.space.mapper.SpaceMapper;
import com.example.room.space.repository.SpaceRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SpaceDAOImpl implements SpaceDAO {

    private final SpaceRepository spaceRepository;

    SpaceMapper spaceMapper = Mappers.getMapper(SpaceMapper.class);
//    private final SpaceMapper spaceMapper = Mapppin;
    @Override
    public Space create(SpaceDto spaceDto) {
        Space space = spaceMapper.convertSpaceEntity(spaceDto);
        return spaceRepository.save(space);
    }

    @Override
    public List<Space> getSpaces() {
        return null;
    }

    @Override
    public SpaceDto getSpace() {
        long test = 1000L;
//        Space space = spaceMapper.convertSpaceEntity(spaceDto);
        Optional<Space> space = spaceRepository.findById(test);
        SpaceDto spaceDto = spaceMapper.convertSpaceDto(space.get());
        return spaceDto;
    }

    @Override
    public Space update() {
        return null;
    }

    @Override
    public void delete() {

    }
}
