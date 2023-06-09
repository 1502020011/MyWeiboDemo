package org.eu.konworkers.myweibodemo;


import org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("main")
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.eu.konworkers.myweibodemo.Controller"))
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfo("MyWeiboDemo Api Documentation",
                "MyWeiboDemo Api Documentation",
                "0.0.1",
                "",
                new Contact("kyou","",""),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
