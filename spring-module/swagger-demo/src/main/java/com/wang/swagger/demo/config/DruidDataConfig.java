package com.wang.swagger.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewFilter;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/23 14:16
 * @description DruidDataSource Config
 */
@Configuration
public class DruidDataConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }


    /**
     * @return 后台监控功能
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        HashMap<String, String> objectObjectHashMap = new HashMap<>(16);
        objectObjectHashMap.put("loginUsername", "admin");
        objectObjectHashMap.put("loginPassword", "admin");
        objectObjectHashMap.put("allow", "");
        bean.setInitParameters(objectObjectHashMap);
        return bean;
    }

    /**
     * @return 配置过滤器
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new StatViewFilter());
        HashMap<String, String> objectObjectHashMap = new HashMap<>(16);
        objectObjectHashMap.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(objectObjectHashMap);
        return bean;
    }

}
