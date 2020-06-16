package com.benmorant.game.holycraap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HolycraapApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {

		SpringApplication app = new SpringApplication(HolycraapApplication.class);
		//app.setAdditionalProfiles("initData");
		ConfigurableApplicationContext context = app.run(args);
		System.out.println("http://localhost:8080/");
	}
}


