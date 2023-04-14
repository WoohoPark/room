package com.example.room.guest.controller;

import com.example.room.guest.dto.GuestDto;
import com.example.room.guest.service.GuestService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guest")
@AllArgsConstructor
@Slf4j
public class GuestController {

    GuestService guestService;

    @PostMapping
    @ApiOperation("게스트 회원 가입")
    public ResponseEntity<GuestDto> join(@RequestBody GuestDto guestDto) {
        GuestDto response = guestService.join(guestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @ApiOperation("게스트 회원 정보 조회")
    public ResponseEntity<GuestDto> info(@RequestParam(name ="name") String name){
        GuestDto response = guestService.find(name);
        return ResponseEntity.ok(response);
    }

}
