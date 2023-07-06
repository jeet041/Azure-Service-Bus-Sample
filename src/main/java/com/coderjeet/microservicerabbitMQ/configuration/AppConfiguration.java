package com.coderjeet.microservicerabbitMQ.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AppConfiguration {

	@Bean
	public CachingConnectionFactory connectionFactory() {
		return new CachingConnectionFactory("localhost");
	}

	@Bean
	public RabbitAdmin amqpAdmin() {
		return new RabbitAdmin(connectionFactory());
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		return new RabbitTemplate(connectionFactory());
	}

	@Bean
	public Queue testQueue() {
		return new Queue("testQueue", true);

	}

	@Bean
	public DirectExchange testExchange() {
		return new DirectExchange("testExchange");
	}

	@Bean
	public Binding BindQueue(DirectExchange testExchange, Queue queue) {
		return BindingBuilder.bind(queue).to(testExchange).with("");
	}
}
