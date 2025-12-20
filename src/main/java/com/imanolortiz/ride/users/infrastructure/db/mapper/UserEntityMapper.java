package com.imanolortiz.ride.users.infrastructure.db.mapper;

import com.imanolortiz.ride.users.domain.model.User;
import com.imanolortiz.ride.users.infrastructure.db.entity.UserEntity;

public class UserEntityMapper {

    public static User toDomain(UserEntity entity) {
        return User
                .builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .fullName(entity.getFullName())
                .password(entity.getPasswordHash())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .deletedAt(entity.getDeletedAt())
                .build();
    }

    public static UserEntity toEntity(User model) {
        return UserEntity
                .builder()
                .id(model.getId())
                .email(model.getEmail())
                .passwordHash(model.getPassword())
                .fullName(model.getFullName())
                .createdAt(model.getCreatedAt())
                .updatedAt(model.getUpdatedAt())
                .deletedAt(model.getDeletedAt())
                .build();
    }

}
