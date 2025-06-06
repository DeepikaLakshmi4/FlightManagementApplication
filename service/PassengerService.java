package com.example.flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.flight.entity.Passenger;
import com.example.flight.repository.PassengerRepository;

@Service
public class PassengerService {
	@Autowired
	private final PassengerRepository passengerrepo;
	public PassengerService(PassengerRepository passengerrepo)
	{
		this.passengerrepo = passengerrepo;
	}
	public List<Passenger> getAllPassengers()
	{
		return passengerrepo.findAll();
	}
	public Passenger getPassengerByID(Long id)
	{
		return passengerrepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Passenger not found with id " + id));
	}
	public Passenger createnewpassenger(Passenger newpassenger)
	{
		return passengerrepo.save(newpassenger);
	}
	public Passenger updatePassengerDetails(Long id, Passenger newdetails)
	{
		Passenger requiredpassenger = getPassengerByID(id);
		requiredpassenger.setPassenger_id(newdetails.getPassenger_id());
		requiredpassenger.setFname(newdetails.getFname());
		requiredpassenger.setLname(newdetails.getLname());
		requiredpassenger.setEmail(newdetails.getEmail());
		requiredpassenger.setPhone_no(newdetails.getPhone_no());
		return passengerrepo.save(requiredpassenger);
	}
	public void deletePassenger(Long id)
	{
		Passenger requiredflight = getPassengerByID(id);
		passengerrepo.delete(requiredflight);
	}
}
