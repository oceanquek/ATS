package com.domain.ATSFlightREST;

import com.domain.util.Colors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtsFlightRestApplication {

	public static void main(String[] args) {
		Colors.pb("SPRING BOOT APPLICATION!");
		SpringApplication.run(AtsFlightRestApplication.class, args);
	}

}
