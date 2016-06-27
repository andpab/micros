package de.saxsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PastaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PastaServiceApplication.class, args);
	}
}
