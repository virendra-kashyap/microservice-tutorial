package com.api.gateway.service.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes().route("ATTENDANCE-SERVICE", r -> r.path("/**").uri("http://localhost:7001"))
				.route("USER-SERVICE", r -> r.path("/**").uri("http://localhost:7000")).build();
	}
}
