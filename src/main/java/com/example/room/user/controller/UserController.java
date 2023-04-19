package com.example.room.user.controller;

import com.example.room.user.dto.UserDto;
import com.example.room.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ApiOperation("회원 등록")
    public ResponseEntity<String> join(@RequestBody UserDto userDto){
        userService.join(userDto);
        return ResponseEntity.ok("JOIN SUCCESS");
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
}
