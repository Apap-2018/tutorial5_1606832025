package com.apap.tutorial_5.service;

import java.util.List;

import com.apap.tutorial_5.model.FlightModel;
import com.apap.tutorial_5.model.PilotModel;

public interface FlightService {
	void addFlight(FlightModel flight);
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
	FlightModel getFlightDetailById(long id);
	void deleteFlight (FlightModel flight);
	List <FlightModel> getFlightList();
	void updateFlight(FlightModel flight, long id);
	void deleteFlightById (long id);

}
