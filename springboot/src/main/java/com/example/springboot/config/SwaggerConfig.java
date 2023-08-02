package com.example.springboot.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration//标明配置类
@EnableSwagger2//开启swagger功能

 public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket getDocket(){
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        //指定封面信息
        apiInfoBuilder.title("CUIT接口文档")
                .description("~o( =∩ω∩= )m~o( =∩ω∩= )m")
                .version("v 2.0.1")
                .build();

        ApiInfo apiInfo = apiInfoBuilder.build();

        //指定生成策略
        Docket docket = new Docket(DocumentationType.SWAGGER_2)//指定文档路径
                .apiInfo(apiInfo)
                .select()
                //选择扫描哪个包中的内容  （）中是全名路径
                .apis(RequestHandlerSelectors.basePackage("com.example.springboot.Controller"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

}

