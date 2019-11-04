package com.javahly.spring25.config;

import com.javahly.spring25.app.MyImportBeanDefinitionRegistrar;
import com.javahly.spring25.app.MyScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/6/30
 * @QQ :1136513099
 * @desc :
 */

@Configuration
@ComponentScan("com.javahly.spring25")
@MyScan
public class AppConfig {
}
