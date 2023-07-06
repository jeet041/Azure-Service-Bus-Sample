package com.coderjeet.microservicerabbitMQ.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AzbQueueSender {
	
	Logger logger = LoggerFactory.getLogger(AzbQueueSender.class);
	private static final String QUEUE_NAME = "demosamplequeue1";


	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Scheduled(fixedDelay = 1000,initialDelay = 500)
	public void send() {
		String message="Hi this is Azure Services Bus Queue Message test";
		this.jmsTemplate.convertAndSend(QUEUE_NAME,
				message);
		logger.info("Message Sent to Queue......");

	}
}
