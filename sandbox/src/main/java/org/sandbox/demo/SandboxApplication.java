package org.sandbox.demo;

import org.sandbox.service.CustomerService;
import org.sandbox.service.FactoryDemoService;
import org.sandbox.service.ProtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="org.sandbox")
@SpringBootApplication
public class SandboxApplication {

	// recommended only for testing...inject in constructor or use setters
	@Autowired 
	ProtoService protoService2;

	public static void main(String[] args) {
		SpringApplication.run(SandboxApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(CustomerService customerService, FactoryDemoService factoryDemoService, ProtoService protoService) {
		return args -> {
			System.out.println("**** Customers ****");
			customerService.getAllCustomers().forEach(System.out::println);

			System.out.println("factory configuration setting: ");
			System.out.println(factoryDemoService.getName());
			System.out.println("Is dev profile: " + factoryDemoService.getIsDev());

			System.out.println("local bean: ");
			protoService.someTask();
			protoService.print();

			System.out.println("global bean: ");
			protoService2.someTask();
			protoService2.print();
		};
	}
}
