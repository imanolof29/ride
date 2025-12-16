package com.imanolortiz.ride.auth.infrastructure.rest;

import com.imanolortiz.ride.auth.application.usecase.SignInUseCase;
import com.imanolortiz.ride.auth.application.usecase.SignUpUseCase;
import com.imanolortiz.ride.auth.infrastructure.dto.AuthResponseDto;
import com.imanolortiz.ride.auth.infrastructure.dto.SignInDto;
import com.imanolortiz.ride.auth.infrastructure.dto.SignUpDto;
import com.imanolortiz.ride.users.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final SignUpUseCase signUpUseCase;
    private final SignInUseCase signInUseCase;

    @PostMapping("/sign-up")
    public ResponseEntity<AuthResponseDto> signUp(@RequestBody() SignUpDto dto) {
        User user = signUpUseCase.execute(dto);
        return ResponseEntity.ok(createAuthResponse(user));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AuthResponseDto> signIn(@RequestBody() SignInDto dto) {
        User user = signInUseCase.execute(dto);
        return ResponseEntity.ok(createAuthResponse(user));
    }

    private AuthResponseDto createAuthResponse(User user) {
        return new AuthResponseDto("access", "refresh");
    }

}
