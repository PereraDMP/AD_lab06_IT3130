package com.example.ridelink_modular_monolith.driver.service;

import com.example.ridelink_modular_monolith.driver.model.Driver;
import com.example.ridelink_modular_monolith.driver.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    private final DriverRepository repository;

    public DriverService(DriverRepository repository) {
        this.repository = repository;
    }

    public Driver createDriver(Driver driver) {
        return repository.save(driver);
    }

    public List<Driver> getAvailableDrivers() {
        return repository.findByAvailableTrue();
    }

    public Driver updateAvailability(Long id, boolean available) {
        Driver driver = repository.findById(id)
                .orElseThrow();

        driver.setAvailable(available);
        return repository.save(driver);
    }

    public Driver findById(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

    public Driver save(Driver driver) {
        return repository.save(driver);
    }
}