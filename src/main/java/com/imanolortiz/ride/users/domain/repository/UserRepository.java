package com.imanolortiz.ride.users.domain.repository;

import com.imanolortiz.ride.users.domain.model.User;

public interface UserRepository {
    User findByEmail(String email);
}
