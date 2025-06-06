package com.example.flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flight.entity.Airport;
import com.example.flight.repository.AirportRepository;


@Service
public class AirportService {

	@Autowired
	private final AirportRepository airportrepo;
	public AirportService(AirportRepository airportrepo)
	{
		this.airportrepo = airportrepo;
	}
	public List<Airport> getAllAirports()
	{
		return airportrepo.findAll();
	}
	public Airport getAirportByID(Long id)
	{
		return airportrepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Airport not found with id " + id));
	}
	public Airport createnewAirport(Airport newairport)
	{
		return airportrepo.save(newairport);
	}
	public Airport updateAirportDetails(Long id, Airport newdetails)
	{
		Airport requiredairport = getAirportByID(id);
		requiredairport.setId(newdetails.getId());
		requiredairport.setCode(newdetails.getCode());
		requiredairport.setName(newdetails.getName());
		requiredairport.setCity(newdetails.getCity());
		requiredairport.setCountry(newdetails.getCountry());
		requiredairport.setLatitude(newdetails.getLatitude());
		requiredairport.setLongitude(newdetails.getLongitude());
		return airportrepo.save(requiredairport);
	}
	public void deleteAirport(Long id)
	{
		Airport requiredairport = getAirportByID(id);
		airportrepo.delete(requiredairport);
	}

}
