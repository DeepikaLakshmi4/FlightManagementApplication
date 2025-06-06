package com.example.flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flight.entity.Booking;
import com.example.flight.entity.Passenger;
import com.example.flight.repository.BookingRepository;
import com.example.flight.repository.PassengerRepository;


@Service
public class BookingService {
	@Autowired
	private BookingRepository bookrepo;
	@Autowired
	private PassengerRepository passengerrepo;
	public BookingService(BookingRepository bookrepo )
	{
		this.bookrepo = bookrepo;
	}
	
	public List<Booking> getAllBooking()
	{
		return bookrepo.findAll();
	}
	public Booking getBookingByID(Long id)
	{
		return bookrepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Booking not found with id " + id));
	}
	public Booking createnewbooking(Booking newBooking)
	{
		Long bookerID = newBooking.getBooker().getPassenger_id();
		Passenger booker = passengerrepo.findById(bookerID)
				.orElseThrow(() -> new RuntimeException("Passenger not found with id: " + bookerID));
		newBooking.setBooker(booker);
		return bookrepo.save(newBooking);
	}
	public Booking updateBookingDetails(Long id, Booking newdetails)
	{
		Booking requiredBooking = getBookingByID(id);
		requiredBooking.setId(newdetails.getId());
		requiredBooking.setBookingDate(newdetails.getBookingDate());
		requiredBooking.setBooker(newdetails.getBooker());
		requiredBooking.setStatus(newdetails.getStatus());
		return requiredBooking;
	}
	public void deleteBooking(Long id)
	{
		Booking requiredBooking = getBookingByID(id);
		bookrepo.delete(requiredBooking);
	}

}
