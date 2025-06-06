package com.example.flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flight.entity.Airport;
import com.example.flight.entity.Schedule;
import com.example.flight.repository.ScheduleRepository;

@Service
public class ScheduleService {

    

    @Autowired
    private final ScheduleRepository scheduleRepo;
    @Autowired
    private AirportService airportservice;
    public ScheduleService(ScheduleRepository scheduleRepo) {
        this.scheduleRepo = scheduleRepo;
    }

    // Get all schedules
    public List<Schedule> getAllSchedules() {
        return scheduleRepo.findAll();
    }

    // Get a schedule by ID
    public Schedule getScheduleById(Long id) {
        return scheduleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found with id " + id));
    }

    // Create a new schedule
    public Schedule createNewSchedule(Schedule newSchedule) {
        Long sourceAirportID = newSchedule.getSource().getId();
        Airport srcairport = airportservice.getAirportByID(sourceAirportID);
        Long destAirportID = newSchedule.getDestination().getId();
        Airport destairport = airportservice.getAirportByID(destAirportID);
        newSchedule.setSource(srcairport);
        newSchedule.setDestination(destairport);
    	return scheduleRepo.save(newSchedule);
    }

    // Update schedule details
    public Schedule updateScheduleDetails(Long id, Schedule newDetails) {
        Schedule existingSchedule = getScheduleById(id);
        existingSchedule.setDepartureTime(newDetails.getDepartureTime());
        existingSchedule.setArrivalTime(newDetails.getArrivalTime());
        existingSchedule.setSource(newDetails.getSource());
        existingSchedule.setDestination(newDetails.getDestination());
        return scheduleRepo.save(existingSchedule);
    }

    // Delete a schedule
    public void deleteSchedule(Long id) {
        Schedule scheduleToDelete = getScheduleById(id);
        scheduleRepo.delete(scheduleToDelete);
    }
}