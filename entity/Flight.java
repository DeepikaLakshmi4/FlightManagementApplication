package com.example.flight.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flight {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	int flight_no;
	String carrier_name;
	String model;
	int seat_capacity;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getFlight_no() {
		return flight_no;
	}
	public void setFlight_no(int flight_no) {
		this.flight_no = flight_no;
	}
	public String getCarrier_name() {
		return carrier_name;
	}
	public void setCarrier_name(String carrier_name) {
		this.carrier_name = carrier_name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSeat_capacity() {
		return seat_capacity;
	}
	public void setSeat_capacity(int seat_capacity) {
		this.seat_capacity = seat_capacity;
	}
	public Flight(long id, int flight_no, String carrier_name, String model, int seat_capacity) {
		super();
		this.id = id;
		this.flight_no = flight_no;
		this.carrier_name = carrier_name;
		this.model = model;
		this.seat_capacity = seat_capacity;
	}
	public Flight()
	{
		
	}
	
}
