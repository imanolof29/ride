package com.imanolortiz.ride.notifications.application.usecase;

import com.imanolortiz.ride.notifications.domain.model.DeviceToken;
import com.imanolortiz.ride.notifications.domain.repository.DeviceTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Component
@AllArgsConstructor
public class UnregisterDeviceTokenUseCase {

    private final DeviceTokenRepository deviceTokenRepository;

    @Transactional
    public DeviceToken execute(String tokenId) {
        if (tokenId == null || tokenId.isBlank()) {
            throw new IllegalArgumentException("tokenId must be provided");
        }

        return deviceTokenRepository.findByToken(tokenId)
                .map(deviceToken -> {
                    if (deviceToken.getDeletedAt() != null) {
                        return deviceToken;
                    }
                    deviceToken.setDeletedAt(Instant.now());
                    return deviceTokenRepository.save(deviceToken);
                })
                .orElseThrow(() -> new DeviceTokenNotFoundException("Device token not found: " + tokenId));
    }

}
