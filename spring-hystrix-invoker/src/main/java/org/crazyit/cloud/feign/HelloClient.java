package org.crazyit.cloud.feign;

import org.crazyit.cloud.feign.HelloClient.HelloClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.Feign;


@FeignClient(name = "spring-hystrix-provider", fallback = HelloClientFallback.class)
public interface HelloClient {

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String hello();

	@Component
	static class HelloClientFallback implements HelloClient {

		public String hello() {
			return "error hello";
		}
	}
}
