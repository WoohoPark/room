package com.example.room.space.service;

import com.example.room.reservation.service.ReservationService;
import com.example.room.space.dto.RequestSpace;
import com.example.room.space.dto.ResponseSpace;
import com.example.room.space.entity.space.Space;
import com.example.room.space.repository.SpaceRepository;
import java.util.List;
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

    private final ReservationService reservationService;

    @Transactional
    public ResponseSpace create(RequestSpace requestSpace) {
        Space space = requestSpace.toEntity();
        return new ResponseSpace(spaceRepository.save(space));
    }

    @Transactional(readOnly = true)
    public ResponseSpace findBySpaceId(Long id) {
        return new ResponseSpace(spaceRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("조회할 수 있는 공간이 없습니다.");
        }));
    }

    @Transactional(readOnly = true)
    public List<ResponseSpace> findAll(Pageable pageable) {
        Page<Space> spaces = spaceRepository.findAll(pageable);
        return spaces.stream()
            .map(ResponseSpace::new)
            .collect(Collectors.toList());
    }

    @Transactional
    public void deleteBySpaceId(Long id) {
        //TODO
        if (reservationService.isHoldReservationBySpaceId(id)) {
            throw new IllegalArgumentException("예약이 예정된 공간입니다. 예약이 있는 경우 삭제하실 수 없습니다.");
        }
        spaceRepository.deleteById(id);
    }

    @Transactional
    public ResponseSpace update(RequestSpace requestSpace) {
        return new ResponseSpace(
            spaceRepository.findSpaceById(requestSpace.getId()).orElseThrow(() -> {
                throw new IllegalArgumentException("수정할 수 있는 공간이 없습니다.");
            }));
    }
}
