package org.crazyit.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookServiceApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(BookServiceApp.class).run(args);
		System.out.println("************************ sc-book-service started **************************");
	}

}
