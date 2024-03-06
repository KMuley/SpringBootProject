package com.cognizant.bookingService.kafkaTopic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

    @Bean
    NewTopic kafkaNewTopic() {
		return TopicBuilder.name("kafkaPractice")
						.build();
	}
	
}
