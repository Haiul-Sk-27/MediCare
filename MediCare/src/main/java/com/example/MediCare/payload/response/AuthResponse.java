package com.example.MediCare.payload.response;

import com.example.MediCare.payload.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String jwt;
    private String message;
    private UserDto user;
    private String password;
}
