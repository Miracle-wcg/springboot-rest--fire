package com.wcg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author chengangw
 * @date 3/8/2017 4:46 PM
 */
@Configuration  //让Spring来加载该类配置
@EnableSwagger2  //启用Swagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())  //创建该Api的基本信息（这些基本信息会展现在文档页面中）
                .select() //返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展
                .apis(RequestHandlerSelectors.basePackage("com.wcg.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("简单优雅的restfun风格")
                .version("1.0")
                .build();
    }
}
