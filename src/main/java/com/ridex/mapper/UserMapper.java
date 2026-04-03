package com.ridex.mapper;

import com.ridex.dto.response.UserResponse;
import com.ridex.entity.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toResponse(User user);
}
