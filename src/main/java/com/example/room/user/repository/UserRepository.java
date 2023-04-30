package com.example.room.user.repository;

import com.example.room.user.entity.User;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(String id);

    Page<User> findAll(Pageable pageable);

    void deleteByUserNo(Long userNo);

    Optional<User> findByUserNo(Long userNo);

}
