package com.imanolortiz.ride.notifications.infrastructure.db.repository;

import com.imanolortiz.ride.notifications.infrastructure.db.entity.DeviceTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeviceTokenJpaRepository extends JpaRepository<DeviceTokenEntity, Long> {

    Optional<DeviceTokenEntity> findByDeviceToken(String token);

}
