package com.coderjeet.microservicerabbitMQ.configuration;

import com.azure.identity.*;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigurationForKeyVault {

	@Value("${app.config.azure.client-secret}")
	private String clientSecret;
	@Value("${app.config.azure.client-id}")
	private String clientId;
	@Value("${app.config.azure.tenant-id}")
	private String tenantId;

	@Value("${spring.cloud.azure.keyvault.secret.property-sources[0].endpoint}")
	private String vaultUri;
	/**
	 * The default credential first checks environment variables for configuration.
	 * If environment configuration is incomplete, it will try managed identity.
	 */

		@Bean
		public SecretClient createSecretClient() {
			ClientSecretCredential clientSecretCredentialBuilder= new ClientSecretCredentialBuilder().
					clientSecret(clientSecret)
					.clientId(clientId)
					.tenantId(tenantId)
					.build();
			return new SecretClientBuilder()
					.vaultUrl(vaultUri)
					.credential(clientSecretCredentialBuilder)
					.buildClient();
		}

//	@Bean
//	public SecretClient createSecretClient() {
//		return new SecretClientBuilder()
//				.vaultUrl(vaultUri)
//				.credential(new ManagedIdentityCredentialBuilder().clientId("9ff186f9-d19d-4730-91a4-d69d6fce690d").build())
//				.buildClient();
//	}
}
