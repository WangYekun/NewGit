package wang.demo.redis.redis;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import wang.demo.redis.redis.entity.UserStudent;

import java.util.HashMap;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void contextLoads() {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G1dLJia1RPkXJrdawp6", "0I5ReY3OiVALY83IkwE9dNKtAq2Ahx");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", "17866630618");
        request.putQueryParameter("SignName", "是我说产品");
        request.putQueryParameter("TemplateCode", "SMS_189521598");
        HashMap<Object, Object> mapSms = new HashMap<>();
        mapSms.put("code", 1231);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(mapSms));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testRedis() {
        // 1. 操作字符串 基本操作都有(设置值和获取值)
        redisTemplate.opsForValue().set("wang", "业坤学习java");
        String wang = (String) redisTemplate.opsForValue().get("wang");
        System.out.println(wang);
    }


    @Test
    void testUserStudent() {
        UserStudent userStudent = new UserStudent("王业坤", 23);
        redisTemplate.opsForValue().set("user", userStudent);
        Object wang = redisTemplate.opsForValue().get("user");
        System.out.println(wang);
    }
}


