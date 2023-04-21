package com.example.room.user.service;

import com.example.room.common.config.auth.constants.AuthRoleStatus;
import com.example.room.user.dto.UserDto;

public interface UserService {

    UserDto join(UserDto userDto);

}
