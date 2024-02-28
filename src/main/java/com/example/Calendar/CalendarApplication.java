package com.example.Calendar;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CalendarApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CalendarApplication.class, args);
		RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
	    System.out.println(restTemplate);
		
	}

}
