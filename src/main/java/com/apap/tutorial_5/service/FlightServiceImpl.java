package com.apap.tutorial_5.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial_5.model.FlightModel;
import com.apap.tutorial_5.model.PilotModel;
import com.apap.tutorial_5.repository.FlightDB;

@Service
@Transactional
public class FlightServiceImpl implements FlightService{

	@Autowired
	private FlightDB flightDb;
	
	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
	}

	@Override
	public FlightModel getFlightDetailByFlightNumber(String flightNumber) {
		// TODO Auto-generated method stub
		return flightDb.findByFlightNumber(flightNumber);
	}

	@Override
	public void deleteFlight(FlightModel flight) {
		// TODO Auto-generated method stub
		flightDb.delete(flight);
		
	}


	@Override
	public FlightModel getFlightDetailById(long id) {
		return flightDb.findById(id);
		
	}

	@Override
	public List<FlightModel> getFlightList() {
		// TODO Auto-generated method stub
		return flightDb.findAll();
	}

	@Override
	public void updateFlight(FlightModel flight, long id) {
		FlightModel old = flightDb.findById(id);
		old.setFlightNumber(flight.getFlightNumber());
		old.setOrigin(flight.getOrigin());;
		old.setDestination(flight.getDestination());
		old.setTime(flight.getTime());
		flightDb.save(old);
		
	}

	@Override
	public void deleteFlightById(long id) {
		flightDb.deleteById(id);
		
	}
	
		
	
	

}

