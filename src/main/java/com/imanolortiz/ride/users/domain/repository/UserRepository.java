package com.imanolortiz.ride.users.domain.repository;

import com.imanolortiz.ride.users.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    User save(User user);
    boolean emailExists(String email);
}
