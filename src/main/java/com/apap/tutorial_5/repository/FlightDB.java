package com.apap.tutorial_5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tutorial_5.model.FlightModel;
import com.apap.tutorial_5.model.PilotModel;


@Repository
public interface FlightDB extends JpaRepository<FlightModel, Long>{
	FlightModel findByFlightNumber(String flightNumber);
	FlightModel findById(long id);
	//void deleteFlightById(long id);
	//FlightModel findByLicenseNumber(String );



}
