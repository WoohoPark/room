package com.example.room.guest.service;

import com.example.room.guest.dto.GuestDto;

public interface GuestService {

    GuestDto join(GuestDto guestDto);

    GuestDto find(String name);
}
