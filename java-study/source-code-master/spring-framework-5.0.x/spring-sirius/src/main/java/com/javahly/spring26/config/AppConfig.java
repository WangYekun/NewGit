package com.javahly.spring26.config;

import com.javahly.spring26.annotation.EnableHly;
import com.javahly.spring26.imports.MyImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/4
 * @QQ :1136513099
 * @desc :
 */
//@Configuration
@ComponentScan("com.javahly.spring26")
@EnableHly
public class AppConfig {
}
