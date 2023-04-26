package com.example.room.space.service;

import com.example.room.space.dto.RequestSpaceDto;
import com.example.room.space.dto.ResponseRentalDto;
import com.example.room.space.dto.ResponseSpaceDto;
import com.example.room.space.entity.rental.Rental;
import com.example.room.space.entity.space.Space;
import com.example.room.space.repository.SpaceRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpaceService {

    private final SpaceRepository spaceRepository;

    @Transactional
    public ResponseSpaceDto create(RequestSpaceDto requestSpaceDto) {
        Space space = spaceRepository.save(requestSpaceDto.toEntity());
        space.updateRental(requestSpaceDto.getRentalDto());
        return space.toDto();
    }

    @Transactional
    public ResponseRentalDto findSpaceById(long id) {
        //TODO 객체그래프탐색확인
        Optional<Space> optionalSpace = spaceRepository.findSpaceById(id);
        optionalSpace.orElseThrow(() -> new IllegalArgumentException("test"));
        return optionalSpace.get().getRental().toDto();
    }
}
