package com.imanolortiz.ride.users.infrastructure.db.adapter;

import com.imanolortiz.ride.users.domain.model.User;
import com.imanolortiz.ride.users.domain.repository.UserRepository;
import com.imanolortiz.ride.users.infrastructure.db.entity.UserEntity;
import com.imanolortiz.ride.users.infrastructure.db.mapper.UserEntityMapper;
import com.imanolortiz.ride.users.infrastructure.db.repository.UserJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return userJpaRepository.findByEmail(email)
                .map(UserEntityMapper::toDomain);
    }

    @Override
    public User save(User user) {
        UserEntity newUser = UserEntityMapper.toEntity(user);
        UserEntity savedUser = userJpaRepository.save(newUser);
        return UserEntityMapper.toDomain(savedUser);
    }

    @Override
    public boolean emailExists(String email) {
        return false;
    }
}
