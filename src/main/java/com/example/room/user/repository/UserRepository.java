package com.example.room.user.repository;

import com.example.room.common.config.auth.constants.AuthRoleStatus;
import com.example.room.space.dto.SpaceDto;
import com.example.room.user.dto.SearchDto;
import com.example.room.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    User findById(String id);

    User findByNickName(String nickName);

    List<User> findAll();

//    List<User> findAllByNickNameOrRoleByUpdateAtDesc(String nickName, AuthRoleStatus role);

    User findByUserNo(long userNo);
}
