package com.example.room.space.controller;

import com.example.room.common.response.BasicResponse;
import com.example.room.space.dto.RequestSpace;
import com.example.room.space.dto.ResponseSpace;
import com.example.room.space.service.SpaceService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/space")
@RequiredArgsConstructor
public class SpaceController {

    private final SpaceService spaceService;
    //TODO 테스트코드 작성, 권한 적용

    @PostMapping
    @ApiOperation("공간_생성")
    public BasicResponse<ResponseSpace> create(@RequestBody RequestSpace requestSpace
    ) {
        ResponseSpace response = spaceService.create(requestSpace);
        return BasicResponse.<ResponseSpace>builder()
            .data(response)
            .build();
    }

    @GetMapping("/all")
    @ApiOperation("공간_전체조회")
    public BasicResponse<List<ResponseSpace>> findAll(
        @PageableDefault(size = 20, sort = "id") Pageable pageable) {
        List<ResponseSpace> response = spaceService.findAll(pageable);
        return BasicResponse.<List<ResponseSpace>>builder().data(response).build();
    }

    @GetMapping("/{spaceId}")
    @ApiOperation("공간_세부조회")
    public BasicResponse<ResponseSpace> findBySpaceId(
        @PathVariable(name = "spaceId") Long id) {
        ResponseSpace response = spaceService.findBySpaceId(id);
        return BasicResponse.<ResponseSpace>builder().data(response).build();
    }

    @DeleteMapping("/{spaceId}")
    @ApiOperation("공간_삭제")
    public BasicResponse remove(@PathVariable(name = "spaceId") Long id) {
        spaceService.deleteBySpaceId(id);
        return BasicResponse.builder().build();
    }

    @PutMapping
    @ApiOperation("공간_수정")
    public BasicResponse<ResponseSpace> update(@RequestBody RequestSpace requestSpace
    ) {
        ResponseSpace response = spaceService.update(requestSpace);
        return BasicResponse.<ResponseSpace>builder()
            .data(response)
            .build();
    }
}
