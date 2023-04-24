package com.example.room.common.config.auth;

import com.example.room.user.entity.User;
import com.example.room.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthUserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public AuthUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = Optional.ofNullable(userRepository.findById(username))
            .orElseThrow(() -> new IllegalArgumentException("해당 ID로 조회되는 사용자가 없습니다."));
        return new AuthUserDetails(user);
    }
}
