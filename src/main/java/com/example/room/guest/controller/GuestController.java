package com.example.room.guest.controller;

import com.example.room.common.config.mapper.annotation.ToEntity;
import com.example.room.guest.dto.GuestDto;
import com.example.room.guest.entity.Guest;
import com.example.room.guest.service.GuestService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/guest")
@AllArgsConstructor
@Slf4j
public class GuestController {

    GuestService guestService;

    @PostMapping
    @ApiOperation("게스트 - 회원가입")
    public ResponseEntity<GuestDto> join(@Valid @RequestBody @ToEntity(Guest.class) GuestDto guestDto) {
        GuestDto response = guestService.join(guestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @ApiOperation("게스트 - 회원조회")
    public ResponseEntity<GuestDto> info(@RequestParam(name ="nickName") String nickName){
        GuestDto response = guestService.find(nickName);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/login")
    @ApiOperation("게스트 - 회원조회")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("TEST");
    }

}
