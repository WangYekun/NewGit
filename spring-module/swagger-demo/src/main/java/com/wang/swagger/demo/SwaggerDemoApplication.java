package com.wang.swagger.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Mark
 * @date 2020/4/22 9:08
 * @description 启动类
 */
@SpringBootApplication
public class SwaggerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerDemoApplication.class, args);
        System.out.println("################# SwaggerDemoApplication is started ####################");
    }

}
