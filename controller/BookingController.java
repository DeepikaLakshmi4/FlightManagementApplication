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

import com.example.flight.entity.Booking;
import com.example.flight.service.BookingService;



@RestController
@RequestMapping(path="/api/booking")
public class BookingController {
	@Autowired
	private BookingService bookingservice;
	
	//creation
	@PostMapping
	public ResponseEntity<Booking> createpassenger(@RequestBody Booking newbooking)
	{
		Booking createdbooking= bookingservice.createnewbooking(newbooking);
		return ResponseEntity.ok(createdbooking);
	}
	
	//get all passenger
	@GetMapping
	public ResponseEntity<List<Booking>> getAllPassengers()
	{
		List<Booking> passengerlist = bookingservice.getAllBooking();
		return ResponseEntity.ok(passengerlist);
	}
	//get by id
	@GetMapping("/{id}")
	public ResponseEntity<Booking> getPassengerDetailByID(@PathVariable Long id)
	{
		Booking requiredPassengerdetail = bookingservice.getBookingByID(id);
		return ResponseEntity.ok(requiredPassengerdetail);
	}
	
	//update
	@PutMapping("/{id}")
	public ResponseEntity<Booking> updatePassengerDetailByID(@PathVariable Long id, @RequestBody Booking passengerDetails)
	{
		Booking updatedDetails = bookingservice.updateBookingDetails(id, passengerDetails);
		return ResponseEntity.ok(updatedDetails);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFLight(@PathVariable Long id)
	{
		bookingservice.deleteBooking(id);
		return ResponseEntity.noContent().build();
	}

}
