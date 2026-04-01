package com.ridex.dto.response;

import com.ridex.enums.Role;

import lombok.*;

@Getter
@Setter

public class AuthResponse {
    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private Long id;
    private String name;
    private String email;
    private Role role;
}
