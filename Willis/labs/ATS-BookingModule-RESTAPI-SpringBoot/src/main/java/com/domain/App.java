package com.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.domain.utility.Colors;
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		Colors.pb("SPRING BOOT APPLICATION !!!");
		SpringApplication.run(App.class, args);	
	}
}
