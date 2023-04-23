package com.example.room.space.dao.impl;

import com.example.room.space.dao.SpaceDAO;
import com.example.room.space.dto.RentalDto;
import com.example.room.space.dto.SpaceDto;
import com.example.room.space.entity.rental.Rental;
import com.example.room.space.entity.space.Space;
import com.example.room.space.mapper.SpaceMapper;
import com.example.room.space.repository.RentalRepository;
import com.example.room.space.repository.SpaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SpaceDAOImpl implements SpaceDAO {

    private final SpaceRepository spaceRepository;
    private final RentalRepository rentalRepository;
    private final SpaceMapper spaceMapper;

    @Override
    public SpaceDto createSpace(SpaceDto spaceDto) {
        Space space = spaceMapper.convertSpaceEntity(spaceDto);

        Space test = spaceRepository.save(space);
        rentalRepository.save(space.getRental());
        SpaceDto test2 = spaceMapper.convertSpaceDto(test);
        return test2;
    }

    @Override
    public List<Space> getSpaces() {
        return null;
    }

    @Override
    public SpaceDto getSpace() {
        long test = 1000L;
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

    @Override
    public RentalDto findRentalById(long id) {
        Optional<Space> optionalSpace = spaceRepository.findById(id);
        Space space = optionalSpace.get();
        RentalDto rentalDto = spaceMapper.convertRentalDto(space.getRental());
        return rentalDto;
    }

    @Override
    public long createRental(RentalDto rentalDto) {
        Rental param = spaceMapper.convertRentalEntity(rentalDto);
        Rental result = rentalRepository.save(param);
        return result.getId();
    }


}
