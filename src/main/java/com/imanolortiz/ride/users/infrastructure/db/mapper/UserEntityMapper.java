package com.imanolortiz.ride.users.infrastructure.db.mapper;

import com.imanolortiz.ride.users.domain.model.User;
import com.imanolortiz.ride.users.infrastructure.db.entity.UserEntity;

public class UserEntityMapper {

    public static User toDomain(UserEntity entity) {
        return new User(entity.getId(), entity.getEmail(), entity.getFullName());
    }

}
