package com.example.room.guest.dao;

import com.example.room.guest.dto.GuestDto;
import com.example.room.guest.entity.Guest;

public interface GuestDAO {
    Guest save(GuestDto guestDto);

    Guest findByNickName(String name);
}
