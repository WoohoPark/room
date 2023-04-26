package com.example.room.user.controller;

import com.example.room.common.response.BasicResponse;
import com.example.room.user.dto.RequestUserDto;
import com.example.room.user.dto.ResponseUserDto;
import com.example.room.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @GetMapping("/login")
//    @ApiOperation("회원_로그인")
//    public BasicResponse<UserDto> login(@RequestBody UserDto userDto) {
//        return BasicResponse.<UserDto>builder().data(userDto).build();
//    }

//    @GetMapping("/authentication")
//    @ApiOperation("회원_권한&정보")
//    public BasicResponse<UserDto> authentication(@AuthenticationPrincipal UserDto userDto) {
//        return BasicResponse.<UserDto>builder().data(userDto).build();
//    }

    @PostMapping
    @ApiOperation("회원등록_API")
    public BasicResponse<ResponseUserDto> join(@RequestBody @Valid RequestUserDto requestUserDto) {
        ResponseUserDto responseDto = userService.join(requestUserDto);
        return BasicResponse.<ResponseUserDto>builder()
            .data(responseDto)
            .build();
    }

    @PutMapping
    @ApiOperation("회원수정_API")
    public BasicResponse<ResponseUserDto> update(
        @RequestBody @Valid RequestUserDto requestUserDto) throws Exception {
        ResponseUserDto responseUserDto = userService.update(requestUserDto);
        return BasicResponse.<ResponseUserDto>builder()
            .data(responseUserDto)
            .build();
    }

    @DeleteMapping("/{userNo}")
    @ApiOperation("회원삭제_API")
    public BasicResponse remove(@PathVariable(name = "userNo") long userNo) {
        userService.deleteByUserNo(userNo);
        return BasicResponse.builder().build();
    }

    @GetMapping
    @ApiOperation("회원전체조회_API")
    public BasicResponse<List<ResponseUserDto>> findAll() {
        List<ResponseUserDto> response = userService.findAll();
        return BasicResponse.<List<ResponseUserDto>>builder()
            .data(response)
            .build();
    }
}
