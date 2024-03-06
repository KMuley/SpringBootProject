package com.cognizant.bookingService.serviceImpl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.cognizant.bookingService.service.BookingService;
import com.cognizant.bookingService.util.AppConstant;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public void sendMessage(String booking) {
		kafkaTemplate.send(AppConstant.TOPIC_NAME, booking.toString());
	}

	@Override
	@KafkaListener(topics = AppConstant.TOPIC_NAME, groupId = AppConstant.GROUP_ID)
	public void consume(String message) {
		JSONObject jsonObject = new JSONObject(message);
		System.out.println("current message is: " + jsonObject);
		System.out.println("made a small change in the project");
	}
}
