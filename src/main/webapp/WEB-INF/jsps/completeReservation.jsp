<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Complete Reservation</title>
</head>
<body>
<h2>Complete Reservation:</h2>
Airline: ${flight.operatingAirlines }</br>
Departure city: ${flight.departureCity }</br>
Arrival city: ${flight.arrivalCity }</br>

<form action="completeReservation" method="POST"/>
<pre>
<h2>PassengerDetails:</h2>
First Name:<input type="text" name="passengerFirstName"/>
Last Name:<input type="text" name="passengerlastName"/>
Email:<input type="text" name="passengerEmail"/>
Number:<input type="text" name="passengerNumber"/>

<h2>Card Details:</h2>
Name on the card: <input type="text" name="nameOnTheCard"/>
Card number: <input type="text" name="cardNumber"/>
Expire Date: <input	 type="text" name="expirationDate"/>
Three digit security Code: <input type="text" name="securityCode"/>
	
<input type="hidden" name="flightId" value="${flight.id}"/>
<input type="submit" value="confirm"/>
</pre>
</form>	
</body>
</html>