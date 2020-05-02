package com.vinay.flightreservation.repos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vinay.flightreservation.entities.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query(value = "select * from flight f where f.Departure_City =:departureCity and f.Arrival_city =:arrivalCity and f.Date_Of_Departure =:dateOfDeparture ", nativeQuery = true)
	List<Flight> findFlights(@Param("departureCity")String from, @Param("arrivalCity") String to, @Param("dateOfDeparture") Date departureDate);

	@Query(value = "select * from flight f where f.ID =:flightId", nativeQuery = true)
	Flight findOne(@Param("flightId")Long flightId);

}
