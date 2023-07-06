package com.coderjeet.microservicerabbitMQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJms
public class MicroserviceRabbitMqApplication {

	public static void main(String[] args) {

		SpringApplication.run(MicroserviceRabbitMqApplication.class, args);

	}

}
