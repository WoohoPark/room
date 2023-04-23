package com.example.room.user.service.impl;

import com.example.room.user.entity.User;
import com.example.room.user.repository.UserRepository;
import com.example.room.user.service.UserService;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

//    private final UserDAO userDAO;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

    @Override
    public User join(User paramUser) {
        paramUser.setPassword(bCryptPasswordEncoder.encode(paramUser.getPassword()));
        User findUser =  userRepository.findByUserNo(paramUser.getUserNo());
        if(findUser != null){
            findUser = paramUser;
            return userRepository.save(Objects.requireNonNull(findUser));
        }
        return userRepository.save(paramUser);
    }

//    @Override
//    public Long join(UserDto userDto) {
//        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
//        return userDAO.join(userDto);
//    }
//
//    @Override
//    public List<UserDto> findAllByNickNameOrRoleByUpdateAtDesc(SearchDto searchDto) {
//        return userDAO.findAllByNickNameOrRoleByUpdateAtDesc(searchDto);
//    }
//
//    @Override
//    public long findByUserNo(UserDto userDto) {
//        return userDAO.findByUserNo(userDto);
//    }
}
