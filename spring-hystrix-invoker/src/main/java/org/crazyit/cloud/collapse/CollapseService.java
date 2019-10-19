package org.crazyit.cloud.collapse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.crazyit.cloud.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Component
public class CollapseService {

	// 配置收集1秒内的请求
	@HystrixCollapser(batchMethod = "getPersons", collapserProperties = 
		{ 
			@HystrixProperty(name = "timerDelayInMilliseconds", value = "1000") 
		}
	)
	public Future<Person> getSinglePerson(Integer id) {
		System.out.println("执行单个获取的方法");
		return null;
	}

	@HystrixCommand
	public List<Person> getPersons(List<Integer> ids) {
		System.out.println("收集请求，参数数量：" + ids.size());
		List<Person> ps = new ArrayList<Person>();
		for (Integer id : ids) {
			Person p = new Person();
			p.setId(id);
			p.setName("crazyit");
			ps.add(p);
		}
		return ps;
	}
}
