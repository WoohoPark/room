package com.example.room.space.repository;

import com.example.room.space.entity.space.Space;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceRepository extends JpaRepository<Space, Long> {

    Optional<Space> findSpaceById(long id);
}
