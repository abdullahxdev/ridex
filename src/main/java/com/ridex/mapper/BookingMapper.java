package com.ridex.mapper;

import com.ridex.dto.response.BookingResponse;
import com.ridex.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mapping(source = "rider.id", target = "riderId")
    @Mapping(source = "driver.user.id", target = "driverId")
    @Mapping(source = "rider.name", target = "riderName")
    @Mapping(source = "driver.user.name", target = "driverName")
    BookingResponse toResponse(Booking booking);
}
