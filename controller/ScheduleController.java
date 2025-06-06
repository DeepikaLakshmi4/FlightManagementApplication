package com.example.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.flight.entity.Schedule;
import com.example.flight.service.ScheduleService;

@RestController
@RequestMapping(path = "/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    // Create a new schedule
    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule newSchedule) {
        Schedule createdSchedule = scheduleService.createNewSchedule(newSchedule);
        return ResponseEntity.ok(createdSchedule);
    }

    // Get all schedules
    @GetMapping
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        List<Schedule> scheduleList = scheduleService.getAllSchedules();
        return ResponseEntity.ok(scheduleList);
    }

    // Get schedule by ID
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Long id) {
        Schedule requiredSchedule = scheduleService.getScheduleById(id);
        return ResponseEntity.ok(requiredSchedule);
    }

    // Update schedule by ID
    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateScheduleById(@PathVariable Long id, @RequestBody Schedule scheduleDetails) {
        Schedule updatedSchedule = scheduleService.updateScheduleDetails(id, scheduleDetails);
        return ResponseEntity.ok(updatedSchedule);
    }

    // Delete schedule by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
