package com.example.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flight.entity.Airport;
import com.example.flight.service.AirportService;


@RestController
@RequestMapping(path="/api/airport")
public class AirportController {
	@Autowired
	private AirportService airportservice;
	
	//creation
	@PostMapping
	public ResponseEntity<Airport> createpassenger(@RequestBody Airport newairport)
	{
		Airport createdpassenger= airportservice.createnewAirport(newairport);
		return ResponseEntity.ok(createdpassenger);
	}
	
	//get all passenger
	@GetMapping
	public ResponseEntity<List<Airport>> getAllAirports()
	{
		List<Airport> airportlist = airportservice.getAllAirports();
		return ResponseEntity.ok(airportlist);
	}
	//get by id
	@GetMapping("/{id}")
	public ResponseEntity<Airport> getAirportDetailByID(@PathVariable Long id)
	{
		Airport requiredAirportdetail = airportservice.getAirportByID(id);
		return ResponseEntity.ok(requiredAirportdetail);
	}
	
	//update
	@PutMapping("/{id}")
	public ResponseEntity<Airport> updateAirportDetailByID(@PathVariable Long id, @RequestBody Airport passengerDetails)
	{
		Airport updatedDetails = airportservice.updateAirportDetails(id, passengerDetails);
		return ResponseEntity.ok(updatedDetails);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFLight(@PathVariable Long id)
	{
		airportservice.deleteAirport(id);
		return ResponseEntity.noContent().build();
	}
}
