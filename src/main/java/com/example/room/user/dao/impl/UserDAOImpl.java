package com.example.room.user.dao.impl;

import com.example.room.user.dao.UserDAO;
import com.example.room.user.dto.UserDto;
import com.example.room.user.entity.User;
import com.example.room.user.mapper.UserMapper;
import com.example.room.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {

    private final UserRepository userRepository;

    private final UserMapper userMapper;
    @Override
    public UserDto join(UserDto userDto) {
        User user = userMapper.convertUserEntity(userDto);
        User result = userRepository.save(user);
        return userMapper.convertUserDto(result);
    }
}
