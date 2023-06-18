package com.wisercat.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.HEAD;
import static org.springframework.http.HttpMethod.OPTIONS;
import static org.springframework.http.HttpMethod.PATCH;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Value("${wisercat-backend.security.cors.allowed-origins}")
	private String allowedOrigins;

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/people/**")
			.allowedOrigins(allowedOrigins)
			.allowedMethods(GET.name(), POST.name(), PUT.name(), DELETE.name(), PATCH.name(), HEAD.name(), OPTIONS.name())
			.exposedHeaders(ACCESS_CONTROL_ALLOW_ORIGIN)
			.allowCredentials(true).maxAge(3600);

		// Add more mappings...
	}
}