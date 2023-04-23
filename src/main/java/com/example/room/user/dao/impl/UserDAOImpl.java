package com.example.room.user.dao.impl;

import com.example.room.user.dao.UserDAO;
import com.example.room.user.dto.SearchDto;
import com.example.room.user.dto.UserDto;
import com.example.room.user.entity.User;
import com.example.room.user.mapper.UserMapper;
import com.example.room.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Long join(UserDto userDto) {
        User userEntity = userMapper.convertUserEntity(userDto);
        User result = userRepository.save(userEntity);
        return result.getUserNo();
    }

//    @Override
//    public List<UserDto> findAllByNickNameOrRoleByUpdateAtDesc(SearchDto searchDto) {
////        List<User> result = userRepository.findAllByNickNameOrRoleByUpdateAtDesc(searchDto.getName(),searchDto.getRole());
////        return userMapper.convertUsersDto(result);
//    }

    @Override
    public User findByUserNo(UserDto userDto) {
        return userRepository.findByUserNo(userDto.getUserNo());
    }

}
