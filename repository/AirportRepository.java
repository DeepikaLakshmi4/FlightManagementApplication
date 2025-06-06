package com.example.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flight.entity.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {

}
