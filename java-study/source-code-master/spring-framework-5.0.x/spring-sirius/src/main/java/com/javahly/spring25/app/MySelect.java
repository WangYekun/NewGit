package com.javahly.spring25.app;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/4
 * @QQ :1136513099
 * @desc :
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MySelect {

	public String value() default "SELECT *FROM TEST(模拟Mybatis)";

}
