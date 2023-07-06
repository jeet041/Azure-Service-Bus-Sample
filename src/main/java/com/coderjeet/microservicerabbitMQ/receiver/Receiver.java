package com.coderjeet.microservicerabbitMQ.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


//@Component
public class Receiver {
	Logger logger = LoggerFactory.getLogger(Receiver.class);
	
	@RabbitListener(queues = "testQueue")
	public void receive(String message) {
		logger.info("received message is ======>> {}",message);
	}

}
