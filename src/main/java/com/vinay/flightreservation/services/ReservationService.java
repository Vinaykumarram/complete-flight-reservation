package com.vinay.flightreservation.services;

import com.vinay.flightreservation.dto.ReservationRequest;
import com.vinay.flightreservation.entities.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
