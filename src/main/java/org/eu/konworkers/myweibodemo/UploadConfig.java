package org.eu.konworkers.myweibodemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class UploadConfig {

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();

        resolver.setMaxUploadSize(3 * 1024 * 1024);

        resolver.setMaxInMemorySize(3 * 1024 * 1024);

        resolver.setDefaultEncoding("UTF-8");

        return resolver;
    }
}
