package com.benmorant.game.holycraap;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HolycraapApplication extends SpringBootServletInitializer {

	@SuppressFBWarnings("DLS_DEAD_LOCAL_STORE")
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(HolycraapApplication.class);
		//app.setAdditionalProfiles("initData");
		ConfigurableApplicationContext context = app.run(args);
		System.out.println("http://localhost:8080/");
	}
}
