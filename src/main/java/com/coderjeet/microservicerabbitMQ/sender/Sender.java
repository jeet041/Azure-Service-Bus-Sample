package com.coderjeet.microservicerabbitMQ.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class Sender {
	
	Logger logger = LoggerFactory.getLogger(Sender.class);

	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Scheduled(fixedDelay = 1000,initialDelay = 500)
	public void send() {
		this.rabbitTemplate.convertAndSend("testExchange", "", "Hi this is RabbitMQ sender test");
	}
}
