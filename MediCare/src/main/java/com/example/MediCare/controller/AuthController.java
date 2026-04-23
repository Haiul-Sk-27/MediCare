package com.example.MediCare.controller;

import com.example.MediCare.payload.dto.UserDto;
import com.example.MediCare.payload.response.ApiResponse;
import com.example.MediCare.payload.response.AuthResponse;
import com.example.MediCare.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody UserDto userDto) {

        AuthResponse response = authService.login(userDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(authService.getUserById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<UserDto>> updateInfo(
            @RequestBody UserDto userDto,
            @PathVariable Long id
    ) {

        UserDto updatedUser = authService.updateAdminInfo(userDto, id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Profile updated successfully",
                        updatedUser
                )
        );
    }
}
