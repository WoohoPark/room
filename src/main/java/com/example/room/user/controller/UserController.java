package com.example.room.user.controller;

import com.example.room.common.response.BasicResponse;
import com.example.room.user.dto.UserDto;
import com.example.room.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    @ApiOperation("회원_로그인")
    public BasicResponse<UserDto> login(@RequestBody UserDto userDto) {
        return BasicResponse.<UserDto>builder().data(userDto).build();
    }

    @GetMapping("/authentication")
    @ApiOperation("회원_권한&정보")
    public BasicResponse<UserDto> authentication(@AuthenticationPrincipal UserDto userDto) {
        return BasicResponse.<UserDto>builder().data(userDto).build();
    }

    @PostMapping
    @ApiOperation("회원_등록")
    public BasicResponse<UserDto> join(@RequestBody UserDto requestUserDto) {
        UserDto responseDto = userService.join(requestUserDto);
        return BasicResponse.<UserDto>builder()
            .data(responseDto)
            .build();
    }

    @PutMapping
    @ApiOperation("회원_수정")
    public BasicResponse<UserDto> update(@RequestBody UserDto requestUserDto) {
        UserDto responseDto = userService.update(requestUserDto);
        return BasicResponse.<UserDto>builder()
            .data(responseDto)
            .build();
    }

    @DeleteMapping
    @ApiOperation("회원 삭제")
    public BasicResponse removeByUserNo(long userNo) {
        userService.remove(userNo);
        return BasicResponse.builder().build();
    }

    @GetMapping
    @ApiOperation("회원 전체 검색")
    public BasicResponse<List<UserDto>> findAll(int page, int size, String direction,
        String property) {
        List<UserDto> response = userService.findAll(page, size, direction, property);
        return BasicResponse.<List<UserDto>>builder()
            .data(response)
            .build();
    }
}
