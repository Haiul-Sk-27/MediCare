package com.example.MediCare.controller;

import com.example.MediCare.payload.dto.UserDto;
import com.example.MediCare.payload.response.ApiResponse;
import com.example.MediCare.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final AuthService authService;
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(authService.getUserById(id));
    }

    @PutMapping(value = "/update/{id}", consumes = "multipart/form-data")
    public ResponseEntity<ApiResponse<UserDto>> updateInfo(
            @RequestParam("user") String userJson,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @PathVariable Long id
    ) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        UserDto userDto = objectMapper.readValue(userJson, UserDto.class);

        UserDto updatedUser = authService.updateAdminInfo(userDto, file, id);

        return ResponseEntity.ok(
                new ApiResponse<>("Profile updated successfully", updatedUser)
        );
    }
}
