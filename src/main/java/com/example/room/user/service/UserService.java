package com.example.room.user.service;

import com.example.room.user.dto.RequestUserDto;
import com.example.room.user.dto.ResponseUserDto;
import com.example.room.user.entity.User;
import com.example.room.user.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public ResponseUserDto join(RequestUserDto requestUserDto) {
        requestUserDto.cryptPassword(bCryptPasswordEncoder);
        return new ResponseUserDto(userRepository.save(requestUserDto.toEntity()));
    }

    @Transactional
    public ResponseUserDto update(RequestUserDto requestUserDto) throws Exception {
        User user = userRepository.findByUserNo(requestUserDto.getUserNo()).orElseThrow(
            () -> new IllegalArgumentException("수정할 수 있는 사용자가 존재하지 않습니다.")
        );
        user.update(requestUserDto);
        return new ResponseUserDto(user);
    }

    @Transactional
    public List<ResponseUserDto> findAll() {
        return userRepository.findAll().stream()
            .map(ResponseUserDto::new)
            .collect(Collectors.toList());
    }

    @Transactional
    public void deleteByUserNo(Long userNo) {
        userRepository.deleteByUserNo(userNo);
    }
}