package com.example.room.user.service;

import com.example.room.user.dto.UserDto;
import java.util.List;

public interface UserService {

    UserDto join(UserDto requestUserDto);

    UserDto update(UserDto requestUserDto);

    void remove(long userNo);

    List<UserDto> findAll(int page, int size, String direction, String property);
}
