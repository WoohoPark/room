package com.example.room.space.service;

import com.example.room.space.dto.RequestSpace;
import com.example.room.space.dto.ResponseSpace;
import com.example.room.space.entity.space.Space;
import com.example.room.space.repository.SpaceRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SpaceService {

    private final SpaceRepository spaceRepository;

    @Transactional
    public ResponseSpace create(RequestSpace requestSpace) {
        Space space = spaceRepository.save(requestSpace.toEntity());
        space.updateRental(requestSpace.getRentalDto());
        space.updateFacility(requestSpace.getFacilityDto());
        return space.toDto();
    }

    @Transactional(readOnly = true)
    public ResponseSpace findBySpaceId(long id) {
        return spaceRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("조회할 수 있는 공간이 없습니다.");
        }).toDto();
    }

    @Transactional(readOnly = true)
    public List<ResponseSpace> findAll(Pageable pageable) {
        Page<Space> spaces = spaceRepository.findAll(pageable);
        return spaces.stream()
            .map(Space::toDto)
            .collect(Collectors.toList());
    }

    @Transactional
    public void deleteBySpaceId(long id) {
        spaceRepository.deleteById(id);
    }

    @Transactional
    public ResponseSpace update(RequestSpace requestSpace) {
        Space space = spaceRepository.findSpaceById(requestSpace.getId()).orElseThrow(() -> {
            throw new IllegalArgumentException("수정할 수 있는 공간이 없습니다.");
        });
        space.update(requestSpace);
        return space.toDto();
    }
}
