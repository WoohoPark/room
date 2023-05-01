package com.example.room.space.service;

import com.example.room.space.dto.RequestSpace;
import com.example.room.space.dto.ResponseSpace;
import com.example.room.space.entity.Space;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface SpaceService {

    public ResponseSpace create(RequestSpace requestSpace);

    public Space findSpaceInfoBySpaceId(Long id);

    public ResponseSpace findBySpaceId(Long id);

    public List<ResponseSpace> findAll(Pageable pageable);

    public void deleteBySpaceId(Long id);

    public ResponseSpace update(RequestSpace requestSpace);

}
