package com.example.flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flight.entity.Flight;
import com.example.flight.entity.Schedule;
import com.example.flight.entity.ScheduledFlight;
import com.example.flight.repository.ScheduledFlightRepository;

@Service
public class ScheduledFlightService {

    @Autowired
    private final ScheduledFlightRepository scheduledFlightRepo;
    @Autowired
    private  ScheduleService scheduleservice;
    @Autowired
    private FlightService flightservice;
    public ScheduledFlightService(ScheduledFlightRepository scheduledFlightRepo) {
        this.scheduledFlightRepo = scheduledFlightRepo;
    }

    // Get all Scheduled Flights
    public List<ScheduledFlight> getAllScheduledFlights() {
        return scheduledFlightRepo.findAll();
    }

    // Get Scheduled Flight by ID
    public ScheduledFlight getScheduledFlightByID(Long id) {
        return scheduledFlightRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Scheduled Flight not found with id " + id));
    }

    // Create new Scheduled Flight
    public ScheduledFlight createNewScheduledFlight(ScheduledFlight newScheduledFlight) {
        Long schedule_id = newScheduledFlight.getSchedule().getId();
        Schedule schedule = scheduleservice.getScheduleById(schedule_id);
        newScheduledFlight.setSchedule(schedule);
        
        Long flight_id = newScheduledFlight.getFlight().getId();
        Flight flight = flightservice.getFlightByID(flight_id);
        newScheduledFlight.setFlight(flight);
        return scheduledFlightRepo.save(newScheduledFlight);
    }

    // Update existing Scheduled Flight
    public ScheduledFlight updateScheduledFlightDetails(Long id, ScheduledFlight newDetails) {
        ScheduledFlight requiredScheduledFlight = getScheduledFlightByID(id);
        requiredScheduledFlight.setFlight(newDetails.getFlight());
        requiredScheduledFlight.setSchedule(newDetails.getSchedule());
        requiredScheduledFlight.setAvailableseats(newDetails.getAvailableseats());
        return scheduledFlightRepo.save(requiredScheduledFlight);
    }

    // Delete Scheduled Flight
    public void deleteScheduledFlight(Long id) {
        ScheduledFlight requiredScheduledFlight = getScheduledFlightByID(id);
        scheduledFlightRepo.delete(requiredScheduledFlight);
    }
}

