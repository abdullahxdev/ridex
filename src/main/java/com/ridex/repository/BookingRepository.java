package com.ridex.repository;

import com.ridex.entity.Booking;
import com.ridex.entity.User;
import com.ridex.entity.Driver;
import com.ridex.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByStatus(BookingStatus status);
    List<Booking> findByDriver(Driver driver);
    List<Booking> findByRider(User user);
}
