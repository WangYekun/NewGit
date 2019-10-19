package org.crazyit.cloud;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderApplication {

	public static void main(String[] args) {
		// 读取控制台输入的端口，避免端口冲突
		Scanner scan = new Scanner(System.in);
		String port = scan.nextLine();
		new SpringApplicationBuilder(ProviderApplication.class).properties(
				"server.port=" + port).run(args);
	}
}
