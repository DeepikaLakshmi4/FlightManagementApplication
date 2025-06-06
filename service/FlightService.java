package com.example.flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flight.entity.Flight;
import com.example.flight.repository.FlightRepository;

@Service
public class FlightService {
	@Autowired
	private final FlightRepository flightrepo;
	public FlightService(FlightRepository flightrepo)
	{
		this.flightrepo = flightrepo;
	}
	
	public List<Flight> getAllFlights()
	{
		return flightrepo.findAll();
	}
	public Flight getFlightByID(Long id)
	{
		return flightrepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Flight not found with id " + id));
	}
	public Flight createnewflight(Flight newflight)
	{
		return flightrepo.save(newflight);
	}
	public Flight updateFlightDetails(Long id, Flight newdetails)
	{
		Flight requiredflight = getFlightByID(id);
		requiredflight.setId(newdetails.getId());
		requiredflight.setFlight_no(newdetails.getFlight_no());
		requiredflight.setCarrier_name(newdetails.getCarrier_name());
		requiredflight.setSeat_capacity(newdetails.getSeat_capacity());
		requiredflight.setModel(newdetails.getModel());
		return flightrepo.save(requiredflight);
	}
	public void deleteFlight(Long id)
	{
		Flight requiredflight = getFlightByID(id);
		flightrepo.delete(requiredflight);
	}
}
