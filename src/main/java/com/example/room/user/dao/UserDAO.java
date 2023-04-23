package com.example.room.user.dao;

import com.example.room.space.dto.SpaceDto;
import com.example.room.user.dto.SearchDto;
import com.example.room.user.dto.UserDto;

import com.example.room.user.entity.User;
import java.util.List;

public interface UserDAO {
    Long join(UserDto userDto);

//    List<UserDto> findAllByNickNameOrRoleByUpdateAtDesc(SearchDto searchDto);

    User findByUserNo(UserDto userDto);
}
