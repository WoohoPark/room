package com.example.room.user.service.impl;

import com.example.room.user.dto.UserDto;
import com.example.room.user.entity.User;
import com.example.room.user.mapper.UserMapper;
import com.example.room.user.repository.UserRepository;
import com.example.room.user.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserDto join(UserDto requestUserDto) {
        cryptPassword(requestUserDto);
        User requestUserEntity = userMapper.convertUserEntity(requestUserDto);
        User responseUser = userRepository.save(requestUserEntity);
        return userMapper.convertUserDto(responseUser);
    }

    @Override
    public UserDto update(UserDto requestUserDto) {
        cryptPassword(requestUserDto);
        User responseUser = null;
        User findUser = userRepository.findByUserNo(requestUserDto.getUserNo());
        if (findUser == null) {
            throw new IllegalArgumentException("조회되는 회원번호가 없습니다.");
        }
        User requestUserEntity = userMapper.convertUserEntity(requestUserDto);
        responseUser = userRepository.save(requestUserEntity);
        return userMapper.convertUserDto(responseUser);
    }

    @Override
    public void remove(long userNo) {
        userRepository.deleteById(userNo);
    }

    @Override
    public List<UserDto> findAll(int page, int size, String direction, String property) {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), property);
        Page<User> responseUsers = userRepository.findAll(PageRequest.of(page, size, sort));

        return responseUsers.stream()
            .map(userMapper::convertUserDto)
            .collect(Collectors.toList());
    }

    private void cryptPassword(UserDto userDto) {
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
    }

}
