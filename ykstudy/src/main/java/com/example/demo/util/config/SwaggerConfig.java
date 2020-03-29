package com.example.demo.util.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/3/24 13:56
 * @description Swagger配置类
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = {"com.example.demo"})
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket app() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("app")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .apiInfo(apiInfo());
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 标题
                .title("王业坤自作swagger文档")
                // 描述
                .description("王业坤自作swagger文档")
                //（不可见）条款地址，公司内部使用的话不需要配
                .termsOfServiceUrl("http://www.baidu.com")
                //作者信息
                .contact(new Contact("WangYeKun", "https://blog.wangyekun.top", "638891212@qq.com"))
                //版本号
                .version("1.0")
                .build();
    }
}
