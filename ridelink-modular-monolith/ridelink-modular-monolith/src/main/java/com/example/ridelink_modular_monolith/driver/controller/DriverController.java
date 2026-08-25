package com.example.ridelink_modular_monolith.driver.controller;

import com.example.ridelink_modular_monolith.driver.model.Driver;
import com.example.ridelink_modular_monolith.driver.service.DriverService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    private final DriverService service;

    public DriverController(DriverService service) {
        this.service = service;
    }

    @PostMapping
    public Driver createDriver(
            @RequestBody Driver driver) {
        return service.createDriver(driver);
    }

    @GetMapping("/available")
    public List<Driver> availableDrivers() {
        return service.getAvailableDrivers();
    }

    @PatchMapping("/{id}/availability")
    public Driver changeAvailability(
            @PathVariable Long id,
            @RequestParam boolean available) {

        return service.updateAvailability(id, available);
    }
}