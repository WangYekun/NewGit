package wang.demo.redis.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/5/4 14:01
 * @description 学生用户
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserStudent {

    private String name;

    private Integer age;

}
