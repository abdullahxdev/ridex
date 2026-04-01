package com.ridex.dto.response;

import com.ridex.enums.BookingStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter

public class BookingResponse {
    private Long id;
    private Long riderId;
    private Long driverId;
    private String riderName;
    private String driverName;
    private BigDecimal pickupLat;
    private BigDecimal pickupLng;
    private BigDecimal dropoffLat;
    private BigDecimal dropoffLng;
    private BookingStatus status;
    private BigDecimal fare;
    private BigDecimal distanceKm;
    private LocalDateTime requestedAt;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
}
