package com.apap.tutorial_5.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial_5.model.FlightModel;
import com.apap.tutorial_5.model.PilotModel;
import com.apap.tutorial_5.repository.PilotDB;

@Service
@Transactional
public class PilotServiceImpl implements PilotService{
	
	@Autowired
	private PilotDB pilotDb;
	

	@Override
	public void addPilot(PilotModel pilot) {
		// TODO Auto-generated method stub
		pilotDb.save(pilot);
		
	}

	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}
	

	@Override
	public void deletePilot(PilotModel pilot) {
		// TODO Auto-generated method stub
		pilotDb.delete(pilot);
		
	}

	@Override
	public List<PilotModel> getListPilot() {
		// TODO Auto-generated method stub
		return pilotDb.findAll();
	}

	@Override
	public void updatePilot(PilotModel pilot, long id) {
		// TODO Auto-generated method stub
		PilotModel old = pilotDb.findById(id);
		old.setFlyHour(pilot.getFlyHour());
		old.setName(pilot.getName());
		old.setLicenseNumber(old.getLicenseNumber());
		old.setId(old.getId());
		pilotDb.save(old);
		
	}

	@Override
	public PilotModel getPilotDetailById(long id) {
		return pilotDb.findById(id);
		
	}
	


	

	


}
