package com.vinay.flightreservation.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vinay.flightreservation.dto.ReservationRequest;
import com.vinay.flightreservation.entities.Flight;
import com.vinay.flightreservation.entities.Reservation;
import com.vinay.flightreservation.repos.FlightRepository;
import com.vinay.flightreservation.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepository;
	@Autowired
	ReservationService reservationService;
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ReservationController.class);


	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		LOGGER.info("inside showCompleteReservation() consisting Flight Id:"+ flightId );
		Flight flight = flightRepository.findOne(flightId);
		modelMap.addAttribute("flight", flight);
		LOGGER.info("Flight is:" + flight);
		return "completeReservation";
	}

	@RequestMapping(value = "/completeReservation", method = {RequestMethod.POST })
	public String completeReservation(@ModelAttribute ReservationRequest request, ModelMap modelMap) {
		LOGGER.info("Inside completeReservation() returns request:"+ request);
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully" + reservation.getId());
		return "reservationConfirmation";
	}
}
