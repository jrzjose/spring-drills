package com.micro.demo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.micro.demo.services.TourPackageService;
import com.micro.demo.services.TourService;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public OpenAPI swaggerHeader() {
		return new OpenAPI()e
				.info((new Info())
						.description("Services for the Explore California Relational Database.")
						.title(StringUtils.substringBefore(getClass().getSimpleName(), "$"))
						.version("3.0.0"));
	}

	@SuppressWarnings("deprecation")
	public CommandLineRunner run(TourService tourService, TourPackageService tourPackageService) {
		return args -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String result = encoder.encode("passwordjdbc");

			System.out.println(result);

			UserBuilder users = User.withDefaultPasswordEncoder();
			UserDetails user = users
					.username("user")
					.password("passwordjdbc")
					.roles("USER")
					.build();

			assert encoder.matches("passwordjdbc", user.getPassword());
			assert encoder.matches("passwordjdbc", result);

			// quick service tests...
			System.out.println("Persisted Packages = " + tourPackageService.total());
			System.out.println("Persisted Tours = " + tourService.total());
		};
	}

}
