package com.dawnei.buildlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Main class that bootstraps the Spring Boot application
public class BuildlabApplication {

	public static void main(String[] args) {
		// The below method launches the Spring Boot application and start the embedded Tomcat server
		SpringApplication.run(BuildlabApplication.class, args);
	}

}
