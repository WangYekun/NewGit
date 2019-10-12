package top.billie.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;

/**
 * @program: SpringBootValidate
 * @description:
 * @author: WangYeKun
 * @create: 2019-06-27 17:11
 **/
@Data
public class Users {


    @Future()
    @Range(min = 10, max = 20, message = "11<X<21")
    private String registerDate;

    @NotBlank(message = "用户名不能为空")
    @Length(min = 8, max = 16, message = "请输入8-16位用户名")
    private String name;

    @NotBlank(message = "密码不能为空")
    @Length(min = 8, max = 16, message = "请输入8-16位密码")
    private String password;

    @Min(value = 18, message = "本网站仅限成年人注册")
    private Integer age;

    @Email
    @NotBlank(message = "密码不能为空")
    private String email;

}
