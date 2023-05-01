package com.example.room.user.service;

import com.example.room.user.dto.RequestUser;
import com.example.room.user.dto.ResponseUser;
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
    public ResponseUser join(RequestUser requestUser) {
        requestUser.cryptPassword(bCryptPasswordEncoder);
        return new ResponseUser(userRepository.save(requestUser.toEntity()));
    }

    @Transactional
    public ResponseUser update(RequestUser requestUser){
        User user = userRepository.findByUserNo(requestUser.getUserNo()).orElseThrow(
            () -> new IllegalArgumentException("수정할 수 있는 사용자가 존재하지 않습니다.")
        );
        user.update(requestUser);
        return new ResponseUser(user);
    }

    @Transactional
    public List<ResponseUser> findAll() {
        return userRepository.findAll().stream()
            .map(ResponseUser::new)
            .collect(Collectors.toList());
    }

    @Transactional
    public void deleteByUserNo(Long userNo) {
        userRepository.deleteByUserNo(userNo);
    }
}