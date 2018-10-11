package com.apap.tutorial_5.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial_5.model.FlightModel;
import com.apap.tutorial_5.model.PilotModel;

import com.apap.tutorial_5.service.FlightService;
import com.apap.tutorial_5.service.PilotService;
import com.sun.rowset.internal.Row;

@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;
	private PilotModel pilotUpdate;
	private int index;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	
	
	@RequestMapping(value = "/pilot/view", method = RequestMethod.GET)
	private String view(@RequestParam("licenseNumber") String licenseNumber, Model model) {
		PilotModel archive= pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		
		List<FlightModel> flightList = archive.getPilotFlight();
		
		model.addAttribute("flightList", flightList);
		
		model.addAttribute("pilot", archive);
		
		
		
		return "view-pilot";
	}
	
	@RequestMapping(value = "/pilot/viewallflight/", method = RequestMethod.GET)
	private String viewall(Model model) {
		List<PilotModel> pilotList = pilotService.getListPilot();
		
		model.addAttribute("pilotList", pilotList);
		
		
		
		return "viewall-flight";
	}
	
	@RequestMapping(value = "/pilot/delete/{id}", method = RequestMethod.GET)
	private String deletePilot(@PathVariable String id, Model model) {
		long idd = Long.parseLong(id);
		PilotModel archive= pilotService.getPilotDetailById(idd);
		
		pilotService.deletePilot(archive);
		return "delete";
	}


	
	
	
	
	

	
	@RequestMapping(value="/pilot/update/{id}", method= RequestMethod.GET)
	private String updatePilot(@PathVariable String id, Model model) {
		long idd = Long.parseLong(id);
		PilotModel pilot = pilotService.getPilotDetailById(idd);
		model.addAttribute("pilot", pilot);
		return "updatePilot";
	}
	
	@RequestMapping(value="/pilot/update/{id}", method=RequestMethod.POST)
	private String updatePilot(@PathVariable String id, @ModelAttribute PilotModel pilot) {
		long idd = Long.parseLong(id);
		pilotService.updatePilot(pilot, idd);
		return "update";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pilot", new PilotModel());
		return "addPilot";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "add";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
