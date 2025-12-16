package com.imanolortiz.ride.users.infrastructure.db.adapter;

import com.imanolortiz.ride.users.domain.model.User;
import com.imanolortiz.ride.users.domain.repository.UserRepository;
import com.imanolortiz.ride.users.infrastructure.db.mapper.UserEntityMapper;
import com.imanolortiz.ride.users.infrastructure.db.repository.UserJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
@AllArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User findByEmail(String email) {
        return userJpaRepository.findByEmail(email)
                .map(UserEntityMapper::toDomain)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }
}
