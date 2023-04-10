package com.example.room.guest.controller;

import com.example.room.guest.dto.GuestDto;
import com.example.room.guest.service.GuestService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guest")
@AllArgsConstructor
public class GuestController {

    GuestService guestService;

    @PostMapping
    @ApiOperation("게스트 회원 가입")
    public ResponseEntity join(@RequestBody GuestDto guestDto) {
        guestService.join(guestDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @ApiOperation("게스트 회원 정보 조회")
    public ResponseEntity getInfo(@RequestBody GuestDto guestDto){
        guestDto = guestService.findGuestInfo(guestDto);
        return ResponseEntity.ok().body(guestDto);
    }

}
