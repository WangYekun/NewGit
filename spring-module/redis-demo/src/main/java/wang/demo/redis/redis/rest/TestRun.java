package wang.demo.redis.redis.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/5/2 8:30
 * @description 测试是否启动成功
 */
@RestController
public class TestRun {

    @GetMapping("/testRun")
    public String testRun() {
        return "testRun";
    }
}
