package com.example.room.guest.service.impl;

import com.example.room.guest.dao.GuestDAO;
import com.example.room.guest.dto.GuestDto;
import com.example.room.guest.service.GuestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class GuestServiceImpl implements GuestService {

    GuestDAO guestDAO;

    @Override
    @Transactional
    public void join(GuestDto guestDto) {
        guestDAO.save(guestDto);
    }

    @Override
    @Transactional
    public GuestDto findGuestInfo(GuestDto guestDto) {
        String name = guestDto.getName();
        return guestDAO.findByName(name);
    }

}
