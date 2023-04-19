package com.example.room.user.dao.impl;

import com.example.room.user.dao.UserDAO;
import com.example.room.user.dto.UserDto;
import com.example.room.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserDAOImpl implements UserDAO {

    UserRepository userRepository;

    @Override
    public void join(UserDto userDto) {
        userRepository.save(userDto.toEntity());
    }
}
