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

import com.example.flight.entity.Passenger;
import com.example.flight.service.PassengerService;

@RestController
@RequestMapping(path="/api/passenger")
public class PassengerController {
	@Autowired
	private PassengerService passengerservice;
	
	//creation
	@PostMapping
	public ResponseEntity<Passenger> createpassenger(@RequestBody Passenger newpassenger)
	{
		Passenger createdpassenger= passengerservice.createnewpassenger(newpassenger);
		return ResponseEntity.ok(createdpassenger);
	}
	
	//get all passenger
	@GetMapping
	public ResponseEntity<List<Passenger>> getAllPassengers()
	{
		List<Passenger> passengerlist = passengerservice.getAllPassengers();
		return ResponseEntity.ok(passengerlist);
	}
	//get by id
	@GetMapping("/{id}")
	public ResponseEntity<Passenger> getPassengerDetailByID(@PathVariable Long id)
	{
		Passenger requiredPassengerdetail = passengerservice.getPassengerByID(id);
		return ResponseEntity.ok(requiredPassengerdetail);
	}
	
	//update
	@PutMapping("/{id}")
	public ResponseEntity<Passenger> updatePassengerDetailByID(@PathVariable Long id, @RequestBody Passenger passengerDetails)
	{
		Passenger updatedDetails = passengerservice.updatePassengerDetails(id, passengerDetails);
		return ResponseEntity.ok(updatedDetails);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFLight(@PathVariable Long id)
	{
		passengerservice.deletePassenger(id);
		return ResponseEntity.noContent().build();
	}
}
