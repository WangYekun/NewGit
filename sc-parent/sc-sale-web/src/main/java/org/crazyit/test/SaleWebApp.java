package org.crazyit.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SaleWebApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SaleWebApp.class).run(args);
		System.out.println("************************ sc-sale-web-service started **************************");

	}

}
