package com.wisercat.backend.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.HEAD;
import static org.springframework.http.HttpMethod.OPTIONS;
import static org.springframework.http.HttpMethod.PATCH;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

	@Value("${wisercat-backend.security.cors.allowed-origins}")
	private List<String> allowedOrigins;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.cors().configurationSource((request -> corsConfiguration())).and()
			.csrf().disable()
			.authorizeHttpRequests(auth ->
				auth.requestMatchers(GET,"/person/**").permitAll()
			).sessionManagement().sessionCreationPolicy(STATELESS);
		return httpSecurity.build();
	}

	@Bean
	public CorsConfiguration corsConfiguration() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();

		corsConfiguration.setAllowedOrigins(allowedOrigins);
		corsConfiguration.setExposedHeaders(List.of(ACCESS_CONTROL_ALLOW_ORIGIN));
		corsConfiguration.setAllowedMethods(
			List.of(GET.name(), POST.name(), PUT.name(), DELETE.name(), PATCH.name(), HEAD.name(),
				OPTIONS.name()));
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setMaxAge(3600L);

		return corsConfiguration;
	}
}