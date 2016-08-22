package org.gvaireth.endominion.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan({ "org.gvaireth.core", "org.gvaireth.server" })
@EnableAutoConfiguration
@Configuration
public class EndoMinionApplication {

	public static String ENDO_EMAIL;

	public static String ENDO_PASS;

	public static void main(String[] args) {

		SpringApplication.run(EndoMinionApplication.class, args);
		System.out.println("App healthy!");
		if (args.length == 2) {
			System.out.println("Endomondo email =" + args[0]);
			ENDO_EMAIL = args[0];
			ENDO_PASS = args[1];
		} else {
			System.out.println("usage: java -jar [jarname] [Endomondo email] [Endomondo password]");
		}
	}
}
