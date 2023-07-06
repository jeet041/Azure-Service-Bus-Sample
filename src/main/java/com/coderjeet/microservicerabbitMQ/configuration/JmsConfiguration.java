package com.coderjeet.microservicerabbitMQ.configuration;

import com.azure.spring.cloud.autoconfigure.implementation.jms.properties.AzureServiceBusJmsProperties;
import com.azure.spring.cloud.service.implementation.servicebus.factory.ServiceBusClientBuilderFactory;
import com.azure.spring.jms.ServiceBusJmsConnectionFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSConnectionFactory;
import jakarta.jms.JMSException;
import org.apache.qpid.jms.JmsConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.time.Duration;

//@Configuration
//@EnableJms
public class JmsConfiguration {

       @Value("${remoteUri}")
       private String remoteURI;
        @Bean
        public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
            DefaultJmsListenerContainerFactory factory
                    = new DefaultJmsListenerContainerFactory();
            factory.setConnectionFactory(connectionFactory());
            return factory;

    }

    private ConnectionFactory connectionFactory() {
//            ConnectionFactory connection = new ServiceBusJmsConnectionFactory();
//        CachingConnectionFactory factory = new CachingConnectionFactory(connection);

        ConnectionFactory factory = new ServiceBusJmsConnectionFactory(remoteURI);
//        try {
//            Connection connection = factory.createConnection();
//
//            connection.start();
//        } catch (JMSException e) {
//            e.printStackTrace();
//        }
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate();
        //template.setMessageConverter(jsonMessageConvertor());

//        try {
//            Connection connection = factory.createConnection();
//            connection.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        template.setConnectionFactory(connectionFactory());
       // template.setPubSubDomain(false); // false for a Queue, true for a Topic
        return template;
    }

    @Bean
    public MessageConverter jsonMessageConvertor() {
        MappingJackson2MessageConverter mapping = new MappingJackson2MessageConverter();
        mapping.setTargetType(MessageType.TEXT);
        return mapping;
    }
}
