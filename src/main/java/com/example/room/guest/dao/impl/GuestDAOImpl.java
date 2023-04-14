package com.example.room.guest.dao.impl;

import com.example.room.guest.dao.GuestDAO;
import com.example.room.guest.dto.GuestDto;
import com.example.room.guest.entity.Guest;
import com.example.room.guest.repository.GuestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class GuestDAOImpl implements GuestDAO {

    GuestRepository guestRepository;

    @Override
    public Guest save(GuestDto guestDto) {
        Guest guest = guestDto.toEntity();
        return guestRepository.save(guest);
    }

    @Override
    public Guest findByName(String name) {
        return guestRepository.findByName(name);
    }
}
