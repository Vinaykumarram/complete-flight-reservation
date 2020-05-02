package com.vinay.flightreservation.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vinay.flightreservation.controller.ReservationController;
import com.vinay.flightreservation.dto.ReservationRequest;
import com.vinay.flightreservation.entities.Flight;
import com.vinay.flightreservation.entities.Passenger;
import com.vinay.flightreservation.entities.Reservation;
import com.vinay.flightreservation.repos.FlightRepository;
import com.vinay.flightreservation.repos.PassengerRepository;
import com.vinay.flightreservation.repos.ReservationRepository;
import com.vinay.flightreservation.util.EmailUtil;
import com.vinay.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Value("${com.vinay.flightReservation.itinerary.dirpath}")
	private String ITINERARY_DIR;
//	private String ITINERARY_DIR = "/home/vinay/Documents/reservation";
	
	@Autowired
	FlightRepository flightRepository;
	@Autowired
	PassengerRepository passengerRepository;
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	PDFGenerator pdfGenerator;
	@Autowired
	EmailUtil emailUtil;

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Override
	public Reservation bookFlight(ReservationRequest request) {

		LOGGER.info("inside bookFlight");

		long flightId = request.getFlightId();
		LOGGER.info("fetching flight for FlightId:" + flightId);

		Flight flight = flightRepository.findOne(flightId);

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerlastName());
		passenger.setPhone(request.getPassengerNumber());
		passenger.setEmail(request.getPassengerEmail());
		LOGGER.info("Saving the passenger" + passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		LOGGER.info("Saving the Reservation" + reservation);

		Reservation savedReservation = reservationRepository.save(reservation);

		String filePath = ITINERARY_DIR + savedReservation.getId() + ".pdf";
		LOGGER.info("Generating Itinerary");
		pdfGenerator.generateItinerary(savedReservation, filePath);
		LOGGER.info("Emailing the Itinerary");
		emailUtil.sendItinerary(passenger.getEmail(), filePath);

		return savedReservation;
	}

}
