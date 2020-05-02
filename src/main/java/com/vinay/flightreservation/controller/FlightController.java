package com.vinay.flightreservation.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vinay.flightreservation.entities.Flight;
import com.vinay.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {

	@Autowired
	FlightRepository flightRepository;
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(FlightController.class);


	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyyy") Date departureDate,
			ModelMap modelMap) {
		
		LOGGER.info("inside findFlights() from:" +from + "TO:"+to+ "Departure Date"+ departureDate);
		List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
		System.out.println(flights);
		modelMap.addAttribute("flights", flights);
		LOGGER.info("Flights Found are:" + flights);
		return "displayFlights";
	}
}
