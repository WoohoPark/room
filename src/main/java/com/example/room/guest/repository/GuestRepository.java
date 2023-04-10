package com.example.room.guest.repository;

import com.example.room.guest.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest,Long> {

    Guest findByName(String name);
}
