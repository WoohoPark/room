package com.example.room.guest.dao.impl;

import com.example.room.common.config.mapper.annotation.ToEntity;
import com.example.room.guest.dao.GuestDAO;
import com.example.room.guest.entity.Guest;
import com.example.room.guest.repository.GuestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class GuestDAOImpl implements GuestDAO {

    GuestRepository guestRepository;

    @Override
    public Guest save(@ToEntity(Guest.class) Object object) {

//        Guest guest = @ToEntity(Guest.class) GuestDto;
                System.out.println(object.getClass());
//        Guest guest = guestDto.toEntity();

//        return guestRepository.save(guest);
        return null;
    }

    @Override
    public Guest findByNickName(String name) {
        return guestRepository.findByNickName(name);
    }
}
