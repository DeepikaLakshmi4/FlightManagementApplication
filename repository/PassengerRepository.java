package com.example.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flight.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}
