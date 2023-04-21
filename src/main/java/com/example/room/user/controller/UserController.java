package com.example.room.user.controller;

import com.example.room.common.config.auth.constants.AuthRoleStatus;
import com.example.room.user.dto.UserDto;
import com.example.room.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ApiOperation("회원 등록")
    public ResponseEntity<UserDto> join(@RequestBody UserDto userDto){
        UserDto response = userService.join(userDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/login")
    @ApiOperation("회원 로그인")
    public ResponseEntity<String> login(@RequestBody UserDto userDto){
        return ResponseEntity.ok("LOGIN SUCCESS");
    }

    @GetMapping("/authentication")
    @ApiOperation("권한 확인")
    public ResponseEntity<String> authentication(){
        return ResponseEntity.ok("권한인증");
    }

//    @PostMapping
//    @ApiOperation("게스트 - 회원가입")
//    public ResponseEntity<GuestDto> join(@Valid @RequestBody UserDto userDto) {
//        GuestDto response = userService.join(guestDto);
//        return ResponseEntity.ok(response);
//    }

//    @GetMapping
//    @ApiOperation("게스트 - 회원조회")
//    public ResponseEntity<GuestDto> info(@RequestParam(name ="nickName") String nickName){
//        GuestDto response = userService.find(nickName);
//        return ResponseEntity.ok(response);
//    }

}
