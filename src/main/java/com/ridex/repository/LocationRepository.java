package com.ridex.repository;

import com.ridex.entity.Driver;
import com.ridex.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByDriver(Driver driver);
}
