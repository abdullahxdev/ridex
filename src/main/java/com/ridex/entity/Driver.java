package com.ridex.entity;

import com.ridex.enums.DriverStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private DriverStatus status = DriverStatus.OFFLINE;

    private Double rating;

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    @Column(nullable = false)
    private String vehicleMake;

    @Column(nullable = false)
    private String vehicleModel;

    @Column(nullable = false, unique = true)
    private String vehiclePlate;

    @Column(nullable = false, columnDefinition = "integer default 0")
    @Builder.Default
    private Integer totalTrips = 0;
}
