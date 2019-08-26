package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/8/25 23:21
 * {@link User} {@link Repository}
 */
@Repository
public class UserRepository {
    private final ConcurrentMap<Integer, User> repository =
            new ConcurrentHashMap<>();

    public static final AtomicInteger idGenerator = new AtomicInteger();


    /**
     * 保存对象
     *
     * @param user
     * @return 成功返回 <code>true</code>
     * 失败返回<code>false</code>
     */
    public boolean save(User user) {
        // 设置id从 1 开始，并自动增长
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id, user) == null;
    }
}
