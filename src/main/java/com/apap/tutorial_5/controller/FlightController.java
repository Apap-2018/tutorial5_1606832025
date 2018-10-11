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
public class FlightController {
	private int index;
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
	private String add(@PathVariable(value="licenseNumber") String licenseNumber, Model model) {
		FlightModel flight = new FlightModel();
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		flight.setPilot(pilot);
		
		model.addAttribute("flight", flight);
		return "addFlight";
	}
	
	@RequestMapping(value = "/flight/add", method = RequestMethod.POST)
	private String addFlightSubmit(@ModelAttribute FlightModel flight) {
		flightService.addFlight(flight);
		return "add";
	}
	
	
	@RequestMapping(value = "/flight/delete", method = RequestMethod.POST)
	private String deleteFlight(@ModelAttribute PilotModel pilot, Model model) {
		for(FlightModel flight : pilot.getPilotFlight()) {
			flightService.deleteFlightById(flight.getId());
		}
		return "delete";
	}
	

	
	@RequestMapping(value="/flight/updateFlight/{id}", method= RequestMethod.GET)
	private String updateFlight(@PathVariable (value="id") String id, Model model) {
		long idd = Long.parseLong(id);
		FlightModel flight = flightService.getFlightDetailById(idd);
		model.addAttribute("flight", flight);
		return "updateFlight";
	}
	
	@RequestMapping(value="/flight/updateFlight/{id}", method=RequestMethod.POST)
	private String updateFlight(@PathVariable (value="id") String id, @ModelAttribute FlightModel flight) {
		long idd = Long.parseLong(id);
		flightService.updateFlight(flight, idd);
		return "update";
	}

}
