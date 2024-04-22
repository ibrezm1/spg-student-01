package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.demo.entity.Student;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {
		// Run the Spring Boot application
		
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);


		// Create a new Student object
		Student student = new Student();
		//student.setId(1);

		// print it
		System.out.println(student);

		// Create a new MyBean object
		MyBean myBean = context.getBean(MyBean.class);

		// print it
		System.out.println(myBean.getTestProperty());

	}

}
