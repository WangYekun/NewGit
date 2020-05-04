package wang.demo.redis.redis.jedis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/5/4 12:27
 * @description jedis事务测试
 */
public class JedisTestTx {

    public static void main(String[] args) {
        Jedis jedisParam = new Jedis("127.0.0.1", 6379);
        jedisParam.flushDB();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("wang", "yekun");
        jsonObject.put("wan", "yeku");
        Transaction multiParam = jedisParam.multi();
        String s = jsonObject.toJSONString();
        jedisParam.watch(s);
        try {
            int a = 1 / 0;
            multiParam.set("user1", s);
            System.out.println("a = " + a);
            multiParam.exec();
        } catch (Exception e) {
            multiParam.discard();
            e.printStackTrace();
        } finally {
            System.out.println(jedisParam.get("user1"));
            jedisParam.close();
        }
    }
}
