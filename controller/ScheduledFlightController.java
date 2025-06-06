package com.example.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.flight.entity.ScheduledFlight;
import com.example.flight.service.ScheduledFlightService;

@RestController
@RequestMapping(path = "/api/scheduledFlight")
public class ScheduledFlightController {

    @Autowired
    private ScheduledFlightService scheduledFlightService;

    // Create a new scheduled flight
    @PostMapping
    public ResponseEntity<ScheduledFlight> createScheduledFlight(@RequestBody ScheduledFlight newScheduledFlight) {
        ScheduledFlight createdScheduledFlight = scheduledFlightService.createNewScheduledFlight(newScheduledFlight);
        return ResponseEntity.ok(createdScheduledFlight);
    }

    // Get all scheduled flights
    @GetMapping
    public ResponseEntity<List<ScheduledFlight>> getAllScheduledFlights() {
        List<ScheduledFlight> scheduledFlightList = scheduledFlightService.getAllScheduledFlights();
        return ResponseEntity.ok(scheduledFlightList);
    }

    // Get scheduled flight by ID
    @GetMapping("/{id}")
    public ResponseEntity<ScheduledFlight> getScheduledFlightById(@PathVariable Long id) {
        ScheduledFlight requiredScheduledFlight = scheduledFlightService.getScheduledFlightByID(id);
        return ResponseEntity.ok(requiredScheduledFlight);
    }

    // Update scheduled flight by ID
    @PutMapping("/{id}")
    public ResponseEntity<ScheduledFlight> updateScheduledFlightById(@PathVariable Long id, @RequestBody ScheduledFlight scheduledFlightDetails) {
        ScheduledFlight updatedScheduledFlight = scheduledFlightService.updateScheduledFlightDetails(id, scheduledFlightDetails);
        return ResponseEntity.ok(updatedScheduledFlight);
    }

    // Delete scheduled flight by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScheduledFlight(@PathVariable Long id) {
        scheduledFlightService.deleteScheduledFlight(id);
        return ResponseEntity.noContent().build();
    }
}
