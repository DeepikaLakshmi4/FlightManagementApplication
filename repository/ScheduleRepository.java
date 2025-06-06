package com.example.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flight.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule,Long>{

}
