package com.apap.tutorial_5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tutorial_5.model.PilotModel;

@Repository
public interface PilotDB extends JpaRepository<PilotModel, Long>{
	PilotModel findByLicenseNumber(String licenseNUmber);
	PilotModel findById(long id);
}