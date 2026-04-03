package com.ridex.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter

public class BookingRequest {
    @NotNull
    private BigDecimal pickupLat;

    @NotNull
    private BigDecimal pickupLng;

    @NotNull
    private BigDecimal dropoffLat;

    @NotNull
    private BigDecimal dropoffLng;
}
