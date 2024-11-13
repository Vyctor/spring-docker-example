package com.vyctor.springdockerexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.vyctor.springdockerexample")
@EntityScan("package com.vyctor.springdockerexample")
@SpringBootApplication
public class SpringDockerExampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringDockerExampleApplication.class, args);
	}
}