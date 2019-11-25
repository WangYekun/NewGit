package com.javahly.spring34.config;

import com.javahly.spring34.annotation.EnableMyRedissonHttpSession;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/11
 * @QQ :1136513099
 * @desc :
 */
@Configuration
@ComponentScan("com.javahly.spring34")
@EnableAspectJAutoProxy
//@EnableMyRedissonHttpSession("sirius")
public class AppConfig {
}
