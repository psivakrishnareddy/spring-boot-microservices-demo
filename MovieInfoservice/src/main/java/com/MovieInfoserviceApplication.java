package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class MovieInfoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieInfoserviceApplication.class, args);
	}

}
