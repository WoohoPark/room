package com.example.room.guest.dao;

import com.example.room.guest.dto.GuestDto;
import com.example.room.guest.entity.Guest;

public interface GuestDAO {
    void save(GuestDto guestDto);

    GuestDto findByName(String name);
}
