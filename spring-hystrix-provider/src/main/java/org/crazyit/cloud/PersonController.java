package org.crazyit.cloud;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@RequestMapping(value = "/person/{personId}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findPerson(@PathVariable("personId") Integer personId, HttpServletRequest request) {
		Person person = new Person();
		person.setId(personId);
		person.setName("Crazyit");
		person.setAge(33);
		person.setMessage(request.getRequestURL().toString());		
		return person;
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() throws Exception {
		Thread.sleep(800);
		return "Hello World";
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findPersons(@RequestBody List<Integer> personIds, HttpServletRequest request) {
		List<Person> result = new ArrayList<Person>();
		for(Integer id : personIds) {
			Person person = new Person();
			person.setId(id);
			person.setName("angus");
			person.setAge(new Random().nextInt(30));
			person.setMessage(request.getRequestURL().toString());
			result.add(person);
		}
		return result;
	}
}
