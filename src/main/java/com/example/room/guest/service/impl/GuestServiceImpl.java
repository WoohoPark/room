package com.example.room.guest.service.impl;

import com.example.room.guest.entity.Guest;
import com.example.room.guest.dto.GuestDto;
import com.example.room.guest.repository.GuestRepository;
import com.example.room.guest.service.GuestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GuestServiceImpl implements GuestService {

    GuestRepository guestRepository;

    @Override
    public void join(GuestDto guestDto) {
        guestRepository.save(guestDto.toEntity());
    }

    @Override
    public GuestDto findGuestInfo(GuestDto guestDto) {
        String name = guestDto.getName();
        Guest guest = guestRepository.findByName(name);
        return new GuestDto(guest);
    }

}
