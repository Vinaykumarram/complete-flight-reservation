package com.vinay.flightreservation.entities;

import javax.persistence.Entity;

@Entity
public class Passenger extends AbstractEntity {

	private String firstName;
	private String lastName;
	private String MiddleNumber;
	private String email;
	private String phone;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleNumber() {
		return MiddleNumber;
	}

	public void setMiddleNumber(String middleNumber) {
		MiddleNumber = middleNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
