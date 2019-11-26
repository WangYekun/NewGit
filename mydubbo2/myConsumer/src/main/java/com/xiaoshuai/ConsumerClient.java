package com.xiaoshuai;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerClient {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
		HelloService helloService = (HelloService) context.getBean("helloService");
		String result = helloService.speakHello("xiaoshuai");
		System.out.println(result);
	}
}