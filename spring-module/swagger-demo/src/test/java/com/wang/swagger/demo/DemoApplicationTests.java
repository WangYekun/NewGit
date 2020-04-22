package com.wang.swagger.demo;

import com.wang.swagger.demo.entity.Dog;
import com.wang.swagger.demo.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private Dog dog;

    @Autowired
    private Person person;

    @Test
    void contextLoads() {
        System.out.println("dog = " + dog);
        System.out.println("person = " + person);
    }

}
