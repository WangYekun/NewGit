package org.crazyit.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class MyApplication {

	public static void main(String[] args) {
		// 设置启动的服务器端口
		new SpringApplicationBuilder(MyApplication.class).properties(
				"server.port=8082").run(args);
	}
}
