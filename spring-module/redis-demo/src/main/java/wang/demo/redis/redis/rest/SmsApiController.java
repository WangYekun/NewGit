package wang.demo.redis.redis.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import wang.demo.redis.redis.service.SmsSendService;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/5/3 11:09
 * @description 短信服务接口
 */
@RestController
@RequestMapping(value = "/api/sms")
@CrossOrigin
public class SmsApiController {

    @Autowired
    private SmsSendService smsSendService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping(value = "/send/{phone}")
    public String sendSms(@PathVariable(value = "phone") String phone) {
        String code = redisTemplate.opsForValue().get(phone);
        if (!StringUtils.isEmpty(code)) {
            return "【手机号】" + phone + "【验证码】" + code + "已存在,还没过期,请不要重复发送,谢谢";
        }
        // 生成验证码
        code = UUID.randomUUID().toString().substring(0, 4);
        HashMap<String, Object> map = new HashMap<>(16);
        map.put("code", code);
        boolean isSend = smsSendService.sendSms(phone, "SMS_189521598", map);
        if (isSend) {
            // 设置5分钟过期
            redisTemplate.opsForValue().set(phone, code, 5, TimeUnit.SECONDS);
            return "【手机号】" + phone + "【验证码】" + code + "发送成功";
        } else {
            return "发送失败";
        }
    }
}
