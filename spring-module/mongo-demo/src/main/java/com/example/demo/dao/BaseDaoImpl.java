package com.example.demo.dao;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;

/**
 * @author lenovo
 */
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {

    @Autowired
    private MongoTemplate mongoTemplate;

    private Class<T> clz;

    private Class<T> getClz() {
        if (clz == null) {
            clz = ((Class<T>) (((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
        }
        return clz;
    }

    @Override
    public boolean remove(String id) {
        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query(criteria);
        DeleteResult writeResult = mongoTemplate.remove(query, getClz());
        return writeResult.getDeletedCount() > 0;
    }

    @Override
    public T get(String id) {
        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query(criteria);
        return mongoTemplate.findOne(query, getClz());
    }

    @Override
    public void insert(T t) {
        mongoTemplate.insert(t);
    }

    @Override
    public boolean update(Update update, String id) {
        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query(criteria);
        UpdateResult writeResult = mongoTemplate.updateFirst(query, update, getClz());
        return writeResult.getModifiedCount() > 0;
    }

}
