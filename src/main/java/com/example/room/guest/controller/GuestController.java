package com.example.room.guest.controller;

import com.example.room.guest.dto.GuestDto;
import com.example.room.guest.service.GuestService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
@AllArgsConstructor
public class GuestController {

    GuestService guestService;

    @PostMapping("/join")
    public ResponseEntity join(@RequestBody GuestDto guestDto){
        guestService.join(guestDto);
        return ResponseEntity.ok().build();
    }
}
