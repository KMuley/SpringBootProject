package com.cognizant.bookingService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bookingService.serviceImpl.BookingServiceImpl;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingServiceImpl bookingServiceImpl;

	@GetMapping("/home")
	public String homePage() {
		return "Welcome to the Booking Home";
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> publishMessage(@RequestBody String booking) {
		bookingServiceImpl.sendMessage(booking);
		return ResponseEntity.ok("Message sent successfully to Topic builder");
	}
}
