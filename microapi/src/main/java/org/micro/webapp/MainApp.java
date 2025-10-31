package org.micro.webapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.micro.webapp.data.repository.RoomRepository;
import org.micro.webapp.data.repository.StaffRepository;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}

	@Bean
	public CommandLineRunner run(RoomRepository roomRepository, StaffRepository staffRepository) {
		return args -> {
			System.out.println("**** ROOMS ****");
			roomRepository.findAll().forEach(System.out::println);

			System.out.println("\n\n**** STAFF ****");
			staffRepository.findAll().forEach(System.out::println);
		};
	}
}
