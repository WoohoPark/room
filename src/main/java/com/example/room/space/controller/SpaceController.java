package com.example.room.space.controller;

import com.example.room.space.dto.SpaceDto;
import com.example.room.space.service.SpaceService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/space")
@RequiredArgsConstructor
public class SpaceController {
    private final SpaceService spaceService;

    @PostMapping
    @ApiOperation("공간등록")
    public void create(@RequestBody SpaceDto spaceDto){
        spaceService.create(spaceDto);
    }
}
