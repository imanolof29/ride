package com.imanolortiz.ride.notifications.domain.model;

import com.imanolortiz.ride.users.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DeviceToken {
    private Long id;
    private String deviceToken;
    private User user;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;
}
