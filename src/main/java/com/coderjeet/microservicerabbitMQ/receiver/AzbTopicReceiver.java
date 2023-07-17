package com.coderjeet.microservicerabbitMQ.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

//@Component
public class AzbTopicReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(AzbTopicReceiver.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "${topic.receiver}", containerFactory = "topicJmsListenerContainerFactory",
            subscription = "${test.topic.subscription}")
    public void receiveMessage(String message) {
        LOGGER.info("Message received: {}", message);
    }
}
