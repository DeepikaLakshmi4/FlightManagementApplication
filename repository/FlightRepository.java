package com.example.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flight.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight,Long>{

}
