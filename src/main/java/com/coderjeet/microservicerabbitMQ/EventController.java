package com.coderjeet.microservicerabbitMQ;

import com.azure.security.keyvault.secrets.SecretClient;
import com.coderjeet.microservicerabbitMQ.sender.AzbQueueSender;
import com.coderjeet.microservicerabbitMQ.sender.AzbTopicPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/service/")
public class EventController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);
    @Autowired
    private AzbQueueSender queueSender;

    @Autowired
    private AzbTopicPublisher topicPublisher;

    @Autowired
    private SecretClient secretClient;

    @PostMapping("/send-toQueue")
    public void produceEventsToQueue(@RequestBody String msg){
        queueSender.send(msg);
        String connectionString =  secretClient.getSecret("connectionstring").getValue();
        LOGGER.info("ConnectionString Fetched from key Vault {}",connectionString);
    }

    @PostMapping("/send-toTopic")
    public void produceEventstoTopic(@RequestBody String msg){
        topicPublisher.send(msg);
        String connectionString =  secretClient.getSecret("subscriptionId").getValue();
        LOGGER.info("ConnectionString Fetched from key Vault {}",connectionString);
    }
}
