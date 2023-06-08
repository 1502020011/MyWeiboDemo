package org.eu.konworkers.myweibodemo;


import org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

public class SwaggerConfig {

//    public Docket docket(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .groupName("main");
//    }
//
//    private ApiInfo apiInfo(){
//        return new ApiInfo("MyWeiboDemo Api Documentation",
//                "MyWeiboDemo Api Documentation",
//                "0.0.1",
//                "",
//                new Contact("kyou","",""),
//                "Apache 2.0",
//                "http://www.apache.org/licenses/LICENSE-2.0",
//                new ArrayList());
//    }
}
