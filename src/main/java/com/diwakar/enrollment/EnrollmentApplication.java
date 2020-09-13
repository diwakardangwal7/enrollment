package com.diwakar.enrollment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class EnrollmentApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EnrollmentApplication.class);

	public static void main(String[] args) {
		
		LOGGER.info("Staring enrollment service:::::::::::");
		
		SpringApplication.run(EnrollmentApplication.class, args);
	}

}
