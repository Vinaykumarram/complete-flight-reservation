package com.vinay.flightreservation.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.flightreservation.dto.ReservationUpdateRequest;
import com.vinay.flightreservation.entities.Reservation;
import com.vinay.flightreservation.repos.ReservationRepository;
import com.vinay.flightreservation.util.PDFGenerator;

@RestController
public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepository;
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ReservationRestController.class);


	@RequestMapping("/reservations/{id}")
	public Optional<Reservation> findReservation(@PathVariable("id") Long id) {
		LOGGER.info("inside findReservation() " +id);
		return reservationRepository.findById(id);
	}

	@RequestMapping(value=	"/reservations", method = RequestMethod.POST)
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		LOGGER.info("inside updateReservation() for "+ request);
		Optional<Reservation> reservation = reservationRepository.findById(request.getId());
		reservation.get().setNumberOfBags(request.getNumberOfBags());
		reservation.get().setCheckedIn(request.getCheckedIn());
		LOGGER.info("saving Reservation");
		return reservationRepository.save(reservation.get());
	}
}
