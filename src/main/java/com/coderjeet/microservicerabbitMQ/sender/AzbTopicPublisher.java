package com.coderjeet.microservicerabbitMQ.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//import static org.springframework.amqp.rabbit.core.RabbitAdmin.QUEUE_NAME;

//@Component
public class AzbTopicPublisher {
	
	Logger logger = LoggerFactory.getLogger(AzbTopicPublisher.class);

	@Value("${topic.receiver}")
	private  String Topic;


	@Autowired
	private JmsTemplate jmsTemplate;
	
	//@Scheduled(fixedDelay = 1000,initialDelay = 500)
	public void send(String msg) {
		this.jmsTemplate.convertAndSend(Topic,msg);
		logger.info("Message Sent to Topic......");
	}
}
