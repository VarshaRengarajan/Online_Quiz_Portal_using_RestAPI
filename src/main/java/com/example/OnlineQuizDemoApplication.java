package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example")
@EntityScan("com.example.model")
@EnableJpaRepositories("com.example.repository")
public class OnlineQuizDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineQuizDemoApplication.class, args);
	}

}
