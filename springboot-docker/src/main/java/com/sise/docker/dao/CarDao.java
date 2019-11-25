package com.sise.docker.dao;

import com.sise.docker.domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author idea
 * @data 2019/11/23
 */
@Repository
public interface CarDao extends MongoRepository<Car, Integer> {
}
