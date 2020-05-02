package com.vinay.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinay.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
