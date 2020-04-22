package com.wang.swagger.demo.config;

import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/22 9:08
 * @description swagger config
 */
@Configuration
@EnableSwagger2
@Profile("dev")
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment) {

        Profiles of = Profiles.of("dev");

        boolean b = environment.acceptsProfiles(of);
        System.out.println("b = " + b);

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("WangYeKun")
                // enable to environment config
                .enable(b)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wang.swagger.demo.rest"))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

    @Bean
    public Docket docketTwo() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("WangYeKunTwo")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wang.swagger.demo.controller"))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfo("wang swagger interface"
                , "test swagger"
                , "v1"
                , "url"
                , new Contact("WangYeKun", "https://blog.wangyekun.top/", "849907942@qq.com")
                , "https://blog.wangyekun.top/"
                , "https://blog.wangyekun.top/"
                , Lists.newArrayList());
    }
}
