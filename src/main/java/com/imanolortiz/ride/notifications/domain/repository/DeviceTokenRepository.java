package com.imanolortiz.ride.notifications.domain.repository;

import com.imanolortiz.ride.notifications.domain.model.DeviceToken;

import java.util.Optional;

public interface DeviceTokenRepository {
    DeviceToken save(DeviceToken deviceToken);
    Optional<DeviceToken> findByToken(String token);

}
