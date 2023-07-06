package com.coderjeet.microservicerabbitMQ.configuration;

import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigurationForKeyVault {
	/**
	 * The default credential first checks environment variables for configuration.
	 * If environment configuration is incomplete, it will try managed identity.
	 */
		@Bean
		public SecretClient createSecretClient() {
			return new SecretClientBuilder()
					.vaultUrl("https://demonservicebuskv.vault.azure.net/")
					.credential(new DefaultAzureCredentialBuilder().build())
					.buildClient();
		}
}
