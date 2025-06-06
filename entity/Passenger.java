package com.example.flight.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long passenger_id;
	String fname;
	String lname;
	String email;
	Long phone_no;
	LocalDate dob;
	@OneToMany(mappedBy = "booker", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Booking> listofBookings = new ArrayList<>();
	public Passenger()
	{
		
	}
	public Passenger(Long passenger_id, String fname, String lname, String email, Long phone_no, LocalDate dob) {
		super();
		this.passenger_id = passenger_id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone_no = phone_no;
		this.dob = dob;
	}
	public Long getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(Long passenger_id) {
		this.passenger_id = passenger_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(Long phone_no) {
		this.phone_no = phone_no;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
}
