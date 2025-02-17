package com.example.leftbehindchildren.service;

import com.example.leftbehindchildren.dto.AuthRequest;
import com.example.leftbehindchildren.dto.AuthResponse;
import com.example.leftbehindchildren.entity.User;

public interface AuthService {
    AuthResponse register(AuthRequest request);
    AuthResponse login(AuthRequest request);
    User getCurrentUser();
    void logout();
}