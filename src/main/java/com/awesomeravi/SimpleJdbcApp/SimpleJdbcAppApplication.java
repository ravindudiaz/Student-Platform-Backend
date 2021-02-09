package com.awesomeravi.SimpleJdbcApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.awesomeravi.SimpleJdbcApp.Controllers", "com.awesomeravi.SimpleJdbcApp.Repositories","com.awesommeravi.SimpleJdbcApp.Domain"})
public class SimpleJdbcAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleJdbcAppApplication.class, args);
	}

}
