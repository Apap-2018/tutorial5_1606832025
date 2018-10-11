package com.apap.tutorial_5.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial_5.model.FlightModel;
import com.apap.tutorial_5.model.PilotModel;

public interface PilotService {
	void addPilot(PilotModel pilot);
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	void deletePilot (PilotModel pilot) ;
	List <PilotModel> getListPilot();
	void updatePilot(PilotModel pilot, long id);
	PilotModel getPilotDetailById(long id);

}
