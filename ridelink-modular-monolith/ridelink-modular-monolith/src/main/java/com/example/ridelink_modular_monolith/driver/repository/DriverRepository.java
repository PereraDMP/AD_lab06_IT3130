package com.example.ridelink_modular_monolith.driver.repository;

import com.example.ridelink_modular_monolith.driver.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository
        extends JpaRepository<Driver, Long> {

    List<Driver> findByAvailableTrue();
}