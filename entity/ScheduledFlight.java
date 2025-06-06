package com.example.flight.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ScheduledFlight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	@JoinColumn(name="flight_id")
	Flight flight;
	@ManyToOne
	@JoinColumn(name="schedule_id")
	Schedule schedule;
	int availableseats;
	
	public ScheduledFlight() {
		super();
	}
	public ScheduledFlight(Long id, Flight flight, Schedule schedule, int availableseats) {
		super();
		this.id = id;
		this.flight = flight;
		this.schedule = schedule;
		this.availableseats = availableseats;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public int getAvailableseats() {
		return availableseats;
	}
	public void setAvailableseats(int availableseats) {
		this.availableseats = availableseats;
	}
	
}
