package com.example.room.guest.service;

import com.example.room.guest.dto.GuestDto;

public interface GuestService {

    public void join(GuestDto guestDto);

    GuestDto findGuestInfo(GuestDto guestDto);
}
