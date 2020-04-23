package com.wang.swagger.demo;

import com.wang.swagger.demo.entity.Dog;
import com.wang.swagger.demo.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private Dog dog;

    @Autowired
    private Person person;

    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        System.out.println("dog = " + dog);
        System.out.println("person = " + person);
        System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    }

}
