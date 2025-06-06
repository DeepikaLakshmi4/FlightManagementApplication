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

import com.example.flight.entity.Flight;
import com.example.flight.service.FlightService;

@RestController
@RequestMapping(path="/api/flights")
public class FlightController {
	
	@Autowired
	private FlightService flightservice;
	
	//creation
	@PostMapping
	public ResponseEntity<Flight> createflight(@RequestBody Flight newflight)
	{
		Flight createdflight= flightservice.createnewflight(newflight);
		return ResponseEntity.ok(createdflight);
	}
	
	//get all flights
	@GetMapping
	public ResponseEntity<List<Flight>> getAllFLights()
	{
		List<Flight> flightlist = flightservice.getAllFlights();
		return ResponseEntity.ok(flightlist);
	}
	//get by id
	@GetMapping("/{id}")
	public ResponseEntity<Flight> getFlightDetailByID(@PathVariable Long id)
	{
		Flight requiredFlightdetail = flightservice.getFlightByID(id);
		return ResponseEntity.ok(requiredFlightdetail);
	}
	
	//update
	@PutMapping("/{id}")
	public ResponseEntity<Flight> updateFlightDetailByID(@PathVariable Long id, @RequestBody Flight flightDetails)
	{
		Flight updatedDetails = flightservice.updateFlightDetails(id, flightDetails);
		return ResponseEntity.ok(updatedDetails);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFLight(@PathVariable Long id)
	{
		flightservice.deleteFlight(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
