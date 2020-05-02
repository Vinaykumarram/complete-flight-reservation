package com.vinay.flightreservation.dto;

public class ReservationRequest {

	private long flightId;
	private String passengerFirstName;
	private String passengerlastName;
	private String passengerEmail;
	private String passengerNumber;
	private String nameOnCard;
	private String cardNumber;
	@Override
	public String toString() {
		return "ReservationRequest [flightId=" + flightId + ", passengerFirstName=" + passengerFirstName
				+ ", passengerlastName=" + passengerlastName + ", passengerEmail=" + passengerEmail
				+ ", passengerNumber=" + passengerNumber + ", nameOnCard=" + nameOnCard + ", cardNumber=" + cardNumber
				+ ", expirationDate=" + expirationDate + ", securityCode=" + securityCode + "]";
	}
	private String expirationDate;
	private String securityCode;
	public long getFlightId() {
		return flightId;
	}
	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}
	public String getPassengerFirstName() {
		return passengerFirstName;
	}
	public void setPassengerFirstName(String passengerFirstName) {
		this.passengerFirstName = passengerFirstName;
	}
	public String getPassengerlastName() {
		return passengerlastName;
	}
	public void setPassengerlastName(String passengerlastName) {
		this.passengerlastName = passengerlastName;
	}
	public String getPassengerEmail() {
		return passengerEmail;
	}
	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}
	public String getPassengerNumber() {
		return passengerNumber;
	}
	public void setPassengerNumber(String passengerNumber) {
		this.passengerNumber = passengerNumber;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	
}
