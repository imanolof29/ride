package com.imanolortiz.ride.users.infrastructure.db.repository;

import com.imanolortiz.ride.users.infrastructure.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
