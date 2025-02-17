package com.example.leftbehindchildren.dto;

import com.example.leftbehindchildren.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private User user;
}