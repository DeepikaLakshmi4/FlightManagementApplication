package com.example.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flight.entity.ScheduledFlight;

public interface ScheduledFlightRepository extends JpaRepository<ScheduledFlight,Long>{

}
