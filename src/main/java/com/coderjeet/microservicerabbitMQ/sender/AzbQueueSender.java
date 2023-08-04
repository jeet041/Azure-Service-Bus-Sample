package com.coderjeet.microservicerabbitMQ.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AzbQueueSender {
	
	Logger logger = LoggerFactory.getLogger(AzbQueueSender.class);
	@Value("${test.producer.queue}")
	private String QUEUE_NAME ;

	@Value("${test.consumer.queue}")
	private String QUEUE_NAME2 ;


	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(String message) {
		this.jmsTemplate.convertAndSend(QUEUE_NAME,
				message);
		logger.info("Message Sent to {}",QUEUE_NAME);

	}

	public void sendToQueue2(String message) {
		this.jmsTemplate.convertAndSend(QUEUE_NAME2,
				message);
		logger.info("Message Sent to {}",QUEUE_NAME2);

	}
}
