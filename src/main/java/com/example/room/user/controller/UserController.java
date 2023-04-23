package com.example.room.user.controller;

import com.example.room.common.response.BasicResponse;
import com.example.room.user.dto.SearchDto;
import com.example.room.user.dto.UserDto;
import com.example.room.user.entity.User;
import com.example.room.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @ApiOperation("회원_등록&수정")
    public BasicResponse<User> join(@RequestBody User user) {
        User response = userService.join(user);
        return BasicResponse.<User>builder()
            .data(response)
            .build();
    }
//
//    @PutMapping
//    @ApiOperation("회원_수정")
//    public BasicResponse<Long> edit(@RequestBody UserDto userDto){
////        userService.save(userDto);
//        long response = 1000L;
////        //TODO : MEMBER PUT
//        return BasicResponse.<Long>builder()
//                .data(response)
//                .build();
//    }
//
//    @DeleteMapping
//    @ApiOperation("회원 삭제")
//    public BasicResponse removeByUserNo(long userNo){
//        return BasicResponse.builder().build();
//    }

//    @GetMapping
//    @ApiOperation("회원 검색(조건)")
//    public BasicResponse<List<UserDto>> findAllByNickNameOrRoleByUpdateAtDesc(SearchDto searchDto){
//        List<UserDto> response = userService.findAllByNickNameOrRoleByUpdateAtDesc(searchDto);
//        return BasicResponse.<List<UserDto>>builder()
//                .data(response)
//                .build();
//    }

//    @GetMapping
//    @ApiOperation("회원 검색(조건)")
//    public BasicResponse<List<UserDto>> findAllByNickNameOrRoleByUpdateAtDesc(SearchDto searchDto) {
//        List<UserDto> response = userService.findAllByNickNameOrRoleByUpdateAtDesc(searchDto);
//        return BasicResponse.<List<UserDto>>builder()
//            .data(response)
//            .build();
//    }

}
