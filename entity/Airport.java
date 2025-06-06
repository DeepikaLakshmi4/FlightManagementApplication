package com.example.flight.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String code;
	String name;
	String city;
	String country;
	Double latitude;
	Double longitude;
	 @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<Schedule> departureSchedules = new ArrayList<>();
	 @OneToMany(mappedBy = "source", cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<Schedule> arrivalSchedules = new ArrayList<>();
	 public Airport(Long id, String code, String name, String city, String country, Double latitude, Double longitude) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.city = city;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Airport() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
//	public List<Schedule> getDepartureSchedules() {
//		return departureSchedules;
//	}
//	public void setDepartureSchedules(List<Schedule> departureSchedules) {
//		this.departureSchedules = departureSchedules;
//	}
//	public List<Schedule> getArrivalSchedules() {
//		return arrivalSchedules;
//	}
//	public void setArrivalSchedules(List<Schedule> arrivalSchedules) {
//		this.arrivalSchedules = arrivalSchedules;
//	}
	
	
}
