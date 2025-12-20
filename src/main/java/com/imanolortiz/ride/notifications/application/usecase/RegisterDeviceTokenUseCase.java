package com.imanolortiz.ride.notifications.application.usecase;

import com.imanolortiz.ride.notifications.domain.model.DeviceToken;
import com.imanolortiz.ride.notifications.domain.repository.DeviceTokenRepository;
import com.imanolortiz.ride.notifications.infrastructure.rest.dto.RegisterDeviceTokenDto;
import com.imanolortiz.ride.notifications.infrastructure.rest.mapper.DeviceTokenDtoMapper;
import com.imanolortiz.ride.users.domain.model.User;
import com.imanolortiz.ride.users.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class RegisterDeviceTokenUseCase {

    private final DeviceTokenRepository deviceTokenRepository;
    private final UserRepository userRepository;

    @Transactional
    public DeviceToken execute(RegisterDeviceTokenDto dto, Long userId) {
        User user = findUserOrThrow(userId);
        DeviceToken deviceToken = DeviceTokenDtoMapper.toDomain(dto, user);
        String tokenId = deviceToken.getDeviceToken();

        return deviceTokenRepository.findByToken(tokenId)
                .map(this::reactivateOrReturnExisting)
                .orElseGet(() -> createNewDeviceToken(deviceToken));
    }

    private User findUserOrThrow(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
    }

    private DeviceToken reactivateOrReturnExisting(DeviceToken existing) {
        if (existing.getDeletedAt() == null) {
            return existing;
        }

        existing.setDeletedAt(null);
        existing.setUpdatedAt(Instant.now());
        return deviceTokenRepository.save(existing);
    }

    private DeviceToken createNewDeviceToken(DeviceToken deviceToken) {
        var now = Instant.now();
        deviceToken.setCreatedAt(now);
        deviceToken.setUpdatedAt(now);
        return deviceTokenRepository.save(deviceToken);
    }
}