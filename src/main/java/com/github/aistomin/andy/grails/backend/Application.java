package com.github.aistomin.andy.grails.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class.
 */
@SpringBootApplication
public class Application {

	/**
	 * The application's entry point.
	 *
	 * @param args Command line arguments.
	 */
	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
