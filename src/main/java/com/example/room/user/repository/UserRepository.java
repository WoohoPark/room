package com.example.room.user.repository;

import com.example.room.user.entity.User;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(String id);

    User findByNickName(String nickName);

    Page<User> findAll(Pageable pageable);

    void deleteById(String userId);

    void deleteByUserNo(long userNo);

    Optional<User> findByUserNo(long userNo);

//    User> findByUserNo(long userNo);
}
