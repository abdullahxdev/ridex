package com.ridex.mapper;


import com.ridex.dto.response.DriverResponse;
import com.ridex.entity.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DriverMapper {
    @Mapping(source = "user.id", target="userId")
    @Mapping(source = "user.name", target="name")
    @Mapping(source = "user.phone", target="phone")
    @Mapping(source = "user.email", target="email")
    DriverResponse toResponse(Driver driver);
}