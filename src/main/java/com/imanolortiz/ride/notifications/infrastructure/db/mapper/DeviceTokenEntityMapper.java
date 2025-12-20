package com.imanolortiz.ride.notifications.infrastructure.db.mapper;

import com.imanolortiz.ride.notifications.domain.model.DeviceToken;
import com.imanolortiz.ride.notifications.infrastructure.db.entity.DeviceTokenEntity;
import com.imanolortiz.ride.users.infrastructure.db.mapper.UserEntityMapper;

import java.time.Instant;

public class DeviceTokenEntityMapper {

    public static DeviceToken toDomain(DeviceTokenEntity entity) {
        return DeviceToken
                .builder()
                .id(entity.getId())
                .deviceToken(entity.getDeviceToken())
                .user(UserEntityMapper.toDomain(entity.getUser()))
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .deletedAt(entity.getDeletedAt())
                .build();
    }

    public static DeviceTokenEntity toEntity(DeviceToken model) {
        Instant now = Instant.now();
        return DeviceTokenEntity
                .builder()
                .deviceToken(model.getDeviceToken())
                .user(UserEntityMapper.toEntity(model.getUser()))
                .createdAt(now)
                .updatedAt(now)
                .deletedAt(null)
                .build();
    }

}
