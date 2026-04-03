package com.ridex.service;

import com.ridex.dto.request.LoginRequest;
import com.ridex.dto.request.RegisterRequest;
import com.ridex.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
    AuthResponse refreshToken(String token);
}
