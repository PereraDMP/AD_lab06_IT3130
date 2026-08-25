package com.example.ridelink_modular_monolith.ride.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ridelink_modular_monolith.driver.model.Driver;
import com.example.ridelink_modular_monolith.driver.service.DriverService;
import com.example.ridelink_modular_monolith.ride.model.Ride;
import com.example.ridelink_modular_monolith.ride.model.RideStatus;
import com.example.ridelink_modular_monolith.ride.repository.RideRepository;

import java.util.List;

@Service
public class RideService {

    private final RideRepository rideRepository;
    private final DriverService driverService;

    public RideService(
            RideRepository rideRepository,
            DriverService driverService) {

        this.rideRepository = rideRepository;
        this.driverService = driverService;
    }

    public Ride requestRide(Ride ride) {

        List<Driver> availableDrivers = driverService.getAvailableDrivers();

        if (availableDrivers.isEmpty()) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "No driver available");
        }

        Driver driver = availableDrivers.get(0);

        driver.setAvailable(false);
        driverService.save(driver);

        ride.setDriverId(driver.getId());
        ride.setStatus(RideStatus.ASSIGNED);

        return rideRepository.save(ride);
    }

    public Ride getRide(Long id) {
        return rideRepository.findById(id)
                .orElseThrow();
    }

    public Ride completeRide(Long id) {

        Ride ride = getRide(id);

        Driver driver = driverService.findById(ride.getDriverId());

        driver.setAvailable(true);
        driverService.save(driver);

        ride.setStatus(RideStatus.COMPLETED);

        return rideRepository.save(ride);
    }
}