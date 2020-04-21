package com.spring.wang.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


/**
 * @author niunafei
 * @Profile 注解 标识加载在dev和test文件使用
 */
@Configuration
@EnableSwagger2
//@Profile({"dev", "test"})
public class SwaggerConfig {

    private final static String BASEPACKAGE = "com.spring.wang.rest";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("swagger接口测试")
                //加载配置信息
                .apiInfo(apiInfo())
                //设置全局参数
                .globalOperationParameters(globalParamBuilder())
                //设置全局响应参数
                .globalResponseMessage(RequestMethod.GET, responseBuilder())
                .globalResponseMessage(RequestMethod.POST, responseBuilder())
                .globalResponseMessage(RequestMethod.PUT, responseBuilder())
                .globalResponseMessage(RequestMethod.DELETE, responseBuilder())
                .select()
                //加载swagger 扫描包
                .apis(RequestHandlerSelectors.basePackage(BASEPACKAGE))
                .paths(PathSelectors.any()).build()
                //设置安全认证
                .securitySchemes(security());

    }

    /**
     * 获取swagger创建初始化信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("产品接口文档")
                .contact(new Contact("rongrong", "", "849907213@qq.com"))
                .description("这是SWAGGER_2生成的接口文档")
                .termsOfServiceUrl("NO terms of service")
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("v1.0")
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                // 选择那些路径和api会生成document
                .select()
                // 对所有api进行监控
                .apis(RequestHandlerSelectors.any())
                //不显示错误的接口地址 错误路径不监控
                .paths(Predicates.not(PathSelectors.regex("error.*")))
                // 对根下所有路径进行监控
                .paths(PathSelectors.regex("/.*"))
                .build();
    }


    /**
     * 安全认证参数
     *
     * @return
     */
    private List<ApiKey> security() {
        List<ApiKey> list = new ArrayList<>();
        list.add(new ApiKey("token", "token", "header"));
        return list;
    }

    /**
     * 构建全局参数列表
     *
     * @return
     */
    private List<Parameter> globalParamBuilder() {
        List<Parameter> pars = new ArrayList<>();
        pars.add(parameterBuilder("token", "令牌", "string", "header", false).build());
        return pars;
    }

    /**
     * 创建参数
     *
     * @return
     */
    private ParameterBuilder parameterBuilder(String name, String desc, String type, String parameterType, boolean required) {
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name(name).description(desc).modelRef(new ModelRef(type)).parameterType(parameterType).required(required).build();
        return tokenPar;
    }

    /**
     * 创建全局响应值
     *
     * @return
     */
    private List<ResponseMessage> responseBuilder() {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(200).message("响应成功").build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("服务器内部错误").build());
        return responseMessageList;
    }

}