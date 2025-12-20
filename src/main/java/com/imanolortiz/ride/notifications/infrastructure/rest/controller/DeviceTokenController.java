package com.imanolortiz.ride.notifications.infrastructure.rest.controller;

import com.imanolortiz.ride.notifications.application.usecase.RegisterDeviceTokenUseCase;
import com.imanolortiz.ride.notifications.application.usecase.UnregisterDeviceTokenUseCase;
import com.imanolortiz.ride.notifications.domain.model.DeviceToken;
import com.imanolortiz.ride.notifications.infrastructure.rest.dto.DeviceTokenDto;
import com.imanolortiz.ride.notifications.infrastructure.rest.dto.RegisterDeviceTokenDto;
import com.imanolortiz.ride.notifications.infrastructure.rest.mapper.DeviceTokenDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/device-tokens")
@AllArgsConstructor
public class DeviceTokenController {

    private final RegisterDeviceTokenUseCase registerDeviceTokenUseCase;
    private final UnregisterDeviceTokenUseCase unregisterDeviceTokenUseCase;

    @PostMapping("/register")
    public ResponseEntity<DeviceTokenDto> registerDeviceToken(@RequestBody() RegisterDeviceTokenDto dto) {
        DeviceToken deviceToken = registerDeviceTokenUseCase.execute(dto, 1L);
        return ResponseEntity.ok(DeviceTokenDtoMapper.toDto(deviceToken));
    }

    @PostMapping("/unregister")
    public ResponseEntity<DeviceTokenDto> unregisterDeviceToken(@RequestBody() RegisterDeviceTokenDto dto) {
        DeviceToken deviceToken = unregisterDeviceTokenUseCase.execute(dto.getDeviceToken());
        return ResponseEntity.ok(DeviceTokenDtoMapper.toDto(deviceToken));
    }

}
