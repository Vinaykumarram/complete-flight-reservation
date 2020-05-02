package com.vinay.flightreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.vinay.flightreservation.controller.ReservationController;

@Component
public class EmailUtil {

	@Value("${com.vinay.flightReservation.itinerary.email.body}")
	private String EMAIL_BODY;
//	private String EMAIL_BODY = "Please find your attached Itinerary";

	@Value("${com.vinay.flightReservation.itinerary.email.subject}")
	private String EMAIL_SUBJECT;
//	private String EMAIL_SUBJECT = "ITINERARY FOR YOUR FLIGHT";

	@Autowired
	private JavaMailSender sender;
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(EmailUtil.class);


	public void sendItinerary(String toAddress, String filePath) {
		LOGGER.info("Inside sendItinerary()");

		MimeMessage message = sender.createMimeMessage();

		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
			messageHelper.setTo(toAddress);
			messageHelper.setSubject(EMAIL_SUBJECT);
			messageHelper.setText(EMAIL_BODY);
			messageHelper.addAttachment("Itinerary", new File(filePath));
			sender.send(message);

			new MimeMessageHelper(message, true);
		} catch (MessagingException e) {
			LOGGER.error("Exception sendItinerary()" +e);
		}
	}
}
