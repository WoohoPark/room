package com.example.room.space.controller;

import com.example.room.common.response.BasicResponse;
import com.example.room.space.dto.RequestSpaceDto;
import com.example.room.space.dto.ResponseRentalDto;
import com.example.room.space.dto.ResponseSpaceDto;
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
    @ApiOperation("공간_생성")
    public BasicResponse<ResponseSpaceDto> create(@RequestBody RequestSpaceDto requestSpaceDto
//,        @AuthenticationPrincipal RequestUserDto userDto
    ) {
        //TODO 테스트코드 작성, 권한 적용
        ResponseSpaceDto response = spaceService.create(requestSpaceDto);
        return BasicResponse.<ResponseSpaceDto>builder().data(response).build();
    }

    @GetMapping("/{spaceId}")
    @ApiOperation("공간_렌탈_조회")
    public BasicResponse<ResponseRentalDto> findSpaceById(
        @PathVariable(name = "spaceId") long id) {
        //TODO 테스트코드 작성, 권한 적용
        ResponseRentalDto response = spaceService.findSpaceById(id);
        return BasicResponse.<ResponseRentalDto>builder()
            .data(response)
            .build();
    }

}
