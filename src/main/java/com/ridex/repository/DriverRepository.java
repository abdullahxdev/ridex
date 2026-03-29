package com.ridex.repository;

import com.ridex.entity.Driver;
import java.util.*;

import com.ridex.entity.User;
import com.ridex.enums.DriverStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    List<Driver> findByStatus(DriverStatus status);
    Optional<Driver> findByUser(User user);
}
