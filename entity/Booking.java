package com.example.flight.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	LocalDateTime BookingDate;
	@ManyToOne
	@JoinColumn(name="passenger_id")
	Passenger booker;
	String status;
	
	public Booking(Long id, LocalDateTime bookingDate, Passenger booker, String status) {
		super();
		this.id = id;
		BookingDate = bookingDate;
		this.booker = booker;
		this.status = status;
	}
	
	public Booking() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getBookingDate() {
		return BookingDate;
	}
	public void setBookingDate(LocalDateTime bookingDate) {
		BookingDate = bookingDate;
	}
	public Passenger getBooker() {
		return booker;
	}
	public void setBooker(Passenger booker) {
		this.booker = booker;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

