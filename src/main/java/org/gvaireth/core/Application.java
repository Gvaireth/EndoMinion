package org.gvaireth.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan({ "org.gvaireth.core", "org.gvaireth.server" })
@EnableAutoConfiguration
@Configuration
public class Application {

	public static String ENDO_EMAIL;

	public static String ENDO_PASS;

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		System.out.println("App healthy!");
		System.out.println("ENDO_EMAIL =" + args[0]);
		// System.out.println("args[1] =" + args[1]);
		ENDO_EMAIL = args[0];
		ENDO_PASS = args[1];
	}
}
