package com.example.room.user.repository;

import com.example.room.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(String id);

    User findByNickName(String nickName);

    Page<User> findAll(Pageable pageable);

    User findByUserNo(long userNo);
}
