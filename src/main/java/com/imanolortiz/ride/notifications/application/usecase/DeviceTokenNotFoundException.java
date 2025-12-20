package com.imanolortiz.ride.notifications.application.usecase;

public class DeviceTokenNotFoundException extends RuntimeException {
    public DeviceTokenNotFoundException(String message) {
        super(message);
    }
}

