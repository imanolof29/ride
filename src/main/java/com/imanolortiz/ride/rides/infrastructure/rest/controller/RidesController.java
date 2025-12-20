package com.imanolortiz.ride.rides.infrastructure.rest.controller;

import com.imanolortiz.ride.auth.domain.model.CurrentUser;
import com.imanolortiz.ride.rides.application.usecase.FindRideByIdUseCase;
import com.imanolortiz.ride.rides.application.usecase.FindUserRidesUseCase;
import com.imanolortiz.ride.rides.application.usecase.RequestRideUseCase;
import com.imanolortiz.ride.rides.domain.model.Ride;
import com.imanolortiz.ride.rides.infrastructure.rest.dto.RequestRideDto;
import com.imanolortiz.ride.rides.infrastructure.rest.dto.RideDto;
import com.imanolortiz.ride.rides.infrastructure.rest.mapper.RideDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rides")
@AllArgsConstructor
public class RidesController {

    private final FindUserRidesUseCase findUserRidesUseCase;
    private final FindRideByIdUseCase findRideByIdUseCase;
    private final RequestRideUseCase requestRideUseCase;

    @GetMapping()
    public ResponseEntity<Page<RideDto>> findUserRides() {
        Page<RideDto> rides = findUserRidesUseCase.execute().map(RideDtoMapper::toDto);
        return ResponseEntity.ok(rides);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RideDto> findRideById(@PathVariable() Long id) {
        Ride ride = findRideByIdUseCase.execute(id);
        return ResponseEntity.ok(RideDtoMapper.toDto(ride));
    }

    @PostMapping("/request")
    public ResponseEntity<?> requestRide(
            @AuthenticationPrincipal CurrentUser currentUser,
            @RequestBody() RequestRideDto dto
    ) {
        Ride ride = requestRideUseCase.execute(dto, currentUser.getId());
        return ResponseEntity.ok(RideDtoMapper.toDto(ride));
    }

}
