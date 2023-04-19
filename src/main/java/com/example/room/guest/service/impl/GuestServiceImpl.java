package com.example.room.guest.service.impl;

import com.example.room.guest.dao.GuestDAO;
import com.example.room.guest.dto.GuestDto;
import com.example.room.guest.entity.Guest;
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
    public GuestDto join(GuestDto guestDto) {
        Guest guest = guestDAO.save(guestDto);
        return new GuestDto(guest);
    }

    @Override
    @Transactional
    public GuestDto find(String nickName) {
        Guest guest = guestDAO.findByNickName(nickName);
        return new GuestDto(guest);
    }

}
