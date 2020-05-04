package wang.demo.redis.redis.jedis;

import redis.clients.jedis.Jedis;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/5/4 12:21
 * @description Jedis学习
 */
public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println("jedis.flushAll() = " + jedis.flushAll());
        String ping = jedis.ping();
        // 输入PONG表示连接成功
        System.out.println("ping = " + ping);
    }
}
