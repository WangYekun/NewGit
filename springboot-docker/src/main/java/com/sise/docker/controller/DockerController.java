package com.sise.docker.controller;

import com.sise.docker.config.EnvConfig;
import com.sise.docker.dao.CarDao;
import com.sise.docker.dao.UserDao;
import com.sise.docker.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author idea
 * @data 2019/11/20
 */
@RestController
@RequestMapping(value = "/docker")
public class DockerController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private CarDao carDao;
    @Autowired
    private EnvConfig envConfig;

    @GetMapping(value = "/getEnv")
    private String getEnv() {
        System.out.println(envConfig.getName());
        return envConfig.getName();
    }

    @GetMapping(value = "/insert-mongodb")
    public String insertMongoDB() {
        Car car = new Car();
        car.setId(new Random().nextInt(15000000));
        String number = String.valueOf(System.currentTimeMillis());
        car.setNumber(number);
        carDao.save(car);
        return "this is insert-mongodb";
    }

    @GetMapping(value = "/insert-mysql")
    public String insertMySQL() {
        userDao.insert();
        return "this is insert-mysql";
    }

    @GetMapping(value = "/test2")
    public String test() {
        System.out.println("=========docker test222=========");
        return "this is docker test";
    }
}
