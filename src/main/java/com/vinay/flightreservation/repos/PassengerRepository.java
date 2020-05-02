package com.vinay.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinay.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
