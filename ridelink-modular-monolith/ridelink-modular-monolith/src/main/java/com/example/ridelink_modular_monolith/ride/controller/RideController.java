package com.example.ridelink_modular_monolith.ride.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ridelink_modular_monolith.ride.model.Ride;
import com.example.ridelink_modular_monolith.ride.service.RideService;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    private final RideService service;

    public RideController(RideService service) {
        this.service = service;
    }

    @PostMapping
    public Ride requestRide(
            @RequestBody Ride ride) {

        return service.requestRide(ride);
    }

    @GetMapping("/{id}")
    public Ride getRide(
            @PathVariable Long id) {

        return service.getRide(id);
    }

    @PatchMapping("/{id}/complete")
    public Ride completeRide(
            @PathVariable Long id) {

        return service.completeRide(id);
    }
}