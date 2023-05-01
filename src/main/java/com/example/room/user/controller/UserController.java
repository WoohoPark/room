package com.example.room.user.controller;

import com.example.room.common.response.BasicResponse;
import com.example.room.user.dto.RequestUser;
import com.example.room.user.dto.ResponseUser;
import com.example.room.user.dto.UserDto;
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

    @PostMapping("/login")
    @ApiOperation("회원_로그인")
    public BasicResponse login(@RequestBody UserDto userDto) {
        return BasicResponse.builder().build();
    }

    @GetMapping("/authentication")
    @ApiOperation("회원_권한&정보")
    public BasicResponse<UserDto> authentication(@AuthenticationPrincipal UserDto userDto) {
        return BasicResponse.<UserDto>builder().data(userDto).build();
    }

    @PostMapping
    @ApiOperation("회원등록_API")
    public BasicResponse<ResponseUser> join(@RequestBody @Valid RequestUser requestUser) {
        ResponseUser responseDto = userService.join(requestUser);
        return BasicResponse.<ResponseUser>builder()
            .data(responseDto)
            .build();
    }

    @PutMapping
    @ApiOperation("회원수정_API")
    public BasicResponse<ResponseUser> update(
        @RequestBody @Valid RequestUser requestUser) {
        ResponseUser response = userService.update(requestUser);
        return BasicResponse.<ResponseUser>builder()
            .data(response)
            .build();
    }

    @DeleteMapping("/{userNo}")
    @ApiOperation("회원삭제_API")
    public BasicResponse remove(@PathVariable(name = "userNo") Long userNo) {
        userService.deleteByUserNo(userNo);
        return BasicResponse.builder().build();
    }

    @GetMapping
    @ApiOperation("회원전체조회_API")
    public BasicResponse<List<ResponseUser>> findAll() {
        List<ResponseUser> response = userService.findAll();
        return BasicResponse.<List<ResponseUser>>builder()
            .data(response)
            .build();
    }
}
