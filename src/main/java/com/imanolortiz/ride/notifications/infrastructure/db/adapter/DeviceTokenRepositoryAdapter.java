package com.imanolortiz.ride.notifications.infrastructure.db.adapter;

import com.imanolortiz.ride.notifications.domain.model.DeviceToken;
import com.imanolortiz.ride.notifications.domain.repository.DeviceTokenRepository;
import com.imanolortiz.ride.notifications.infrastructure.db.mapper.DeviceTokenEntityMapper;
import com.imanolortiz.ride.notifications.infrastructure.db.repository.DeviceTokenJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class DeviceTokenRepositoryAdapter implements DeviceTokenRepository {

    private final DeviceTokenJpaRepository deviceTokenJpaRepository;

    @Override
    public DeviceToken save(DeviceToken deviceToken) {
        return null;
    }

    @Override
    public Optional<DeviceToken> findByToken(String token) {
        return deviceTokenJpaRepository.findByDeviceToken(token)
                .map(DeviceTokenEntityMapper::toDomain);
    }
}
