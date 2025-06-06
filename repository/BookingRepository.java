package com.example.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flight.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
