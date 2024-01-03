package com.amex.sms.school;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@SpringBootApplication
@PropertySource("application-e0.properties")
public class SchoolApplication {


	@Autowired
	Environment environment;

	@Value("${school-name}")
	String name;


	static Logger logger = LoggerFactory.getLogger(SchoolApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);

	}

	@PostConstruct
	public void init() {
		logger.info("Our School name is :"+ environment.getProperty("school-name"));
		logger.info("Our School name is :"+ name);
	}
}
