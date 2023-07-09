package com.coderjeet.microservicerabbitMQ;


import com.azure.security.keyvault.secrets.SecretClient;
import com.coderjeet.microservicerabbitMQ.sender.AzbQueueSender;
import com.coderjeet.microservicerabbitMQ.sender.AzbTopicPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

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
        String subscriptionId =  secretClient.getSecret("subscriptionId").getValue();
        LOGGER.info("ConnectionString Fetched from key Vault {}",subscriptionId);
    }

    @Value("azure-blob://testcontainer/test.txt")
    private Resource blobFile;

    @GetMapping("/readBlobFile")
    public String readBlobFile() throws IOException {
        return StreamUtils.copyToString(
                this.blobFile.getInputStream(),
                Charset.defaultCharset());
    }

    @PostMapping("/writeBlobFile")
    public String writeBlobFile(@RequestBody String data) throws IOException {
        try (OutputStream os = ((WritableResource) this.blobFile).getOutputStream()) {
            os.write(data.getBytes());
        }
        return "file was updated";
    }
}
