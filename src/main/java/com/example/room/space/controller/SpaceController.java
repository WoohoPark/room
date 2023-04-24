package com.example.room.space.controller;

import com.example.room.common.response.BasicResponse;
import com.example.room.space.dto.RentalDto;
import com.example.room.space.dto.SpaceDto;
import com.example.room.space.service.SpaceService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/space")
@RequiredArgsConstructor
public class SpaceController {

    private final SpaceService spaceService;

    @PostMapping
    @ApiOperation("공간_생성")
    public ResponseEntity<SpaceDto> create(@RequestBody SpaceDto spaceDto) {
        SpaceDto response = spaceService.create(spaceDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @ApiOperation("공간_렌탈_조회")
    public BasicResponse<RentalDto> findRentalById(long userNo) {
        RentalDto response = spaceService.findRentalById(userNo);
        return BasicResponse.<RentalDto>builder()
            .data(response)
            .build();
    }

}
