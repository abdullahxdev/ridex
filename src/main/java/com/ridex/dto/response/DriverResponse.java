package com.ridex.dto.response;


import com.ridex.enums.DriverStatus;
import lombok.*;

@Getter
@Setter

public class DriverResponse {
    private Long id;
    private Long userId;
    private String name;
    private String email;
    private String phone;
    private DriverStatus status;
    private Double rating;
    private String licenseNumber;
    private String vehicleMake;
    private String vehicleModel;
    private String vehiclePlate;
    private Integer totalTrips;

}
