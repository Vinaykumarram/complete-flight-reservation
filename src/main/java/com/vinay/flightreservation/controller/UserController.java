package com.vinay.flightreservation.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vinay.flightreservation.entities.User;
import com.vinay.flightreservation.repos.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserController.class);
	
	private BCryptPasswordEncoder encoder;

	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		LOGGER.info("Inside showRegistrationPage()");
		return "login/registerUser";
	}

	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		LOGGER.info("Inside register()" + user);
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login/login";
	}

	@RequestMapping("/showLogin")
	public String showLoginPage() {
		LOGGER.info("Inside showLoginPage()");
		return "login/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {
		LOGGER.info("Inside login() and email is:"+ email);
		
		User user = userRepository.findByEmail(email);
		if (user.getPassword().equals(password)) {
			return "login/findFlights";
		} else {
			modelMap.addAttribute("msg", "Invalid username or password, Please Try again");
		}

		return "login/login";
	}
}
