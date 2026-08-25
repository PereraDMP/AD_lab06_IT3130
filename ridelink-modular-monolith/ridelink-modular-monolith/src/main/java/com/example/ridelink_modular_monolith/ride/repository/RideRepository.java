package com.example.ridelink_modular_monolith.ride.repository;

import com.example.ridelink_modular_monolith.ride.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository
        extends JpaRepository<Ride, Long> {
}