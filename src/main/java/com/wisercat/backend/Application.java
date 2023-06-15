package com.wisercat.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.wisercat")
@EnableJpaRepositories("com.wisercat")
@EntityScan("com.wisercat")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
