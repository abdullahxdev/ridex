package com.ridex.dto.response;

import com.ridex.enums.Role;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter

public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Role role;
    private LocalDateTime createdAt;
}
