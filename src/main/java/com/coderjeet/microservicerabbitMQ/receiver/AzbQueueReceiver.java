package com.coderjeet.microservicerabbitMQ.receiver;

import com.azure.security.keyvault.secrets.SecretClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class AzbQueueReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(AzbQueueReceiver.class);
    private static final String QUEUE_NAME = "demosamplequeue1";

    @Autowired
    private SecretClient secretClient;

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = QUEUE_NAME)
    public void receiveMessage(String message) {
        LOGGER.info("Message received: {}", message);
        String connectionString= String.valueOf(secretClient.getSecret("connectionstring"));
        LOGGER.info("ConnectionString Fetched from key Vault {}",connectionString);
    }
}
