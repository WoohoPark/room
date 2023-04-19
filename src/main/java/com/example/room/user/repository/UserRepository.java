package com.example.room.user.repository;

import com.example.room.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findById(String id);

    User findByUserNo(long userNo);

    User findByNickName(String nickName);
}
