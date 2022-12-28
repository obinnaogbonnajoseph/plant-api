package com.udacity.jdnd.course3.lesson1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Lesson1Application {

	public static void main(String[] args) {
		SpringApplication.run(Lesson1Application.class, args);
	}

}
