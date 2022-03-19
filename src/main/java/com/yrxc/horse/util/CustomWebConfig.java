package com.yrxc.horse.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CustomWebConfig  implements WebMvcConfigurer {
    @Value("${user.file.path}")
    private String filepath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/META-INF/resources",
                "classpath:/resources/",
                "classpath:/static/",
                "classpath:/public",
                "file:/"+filepath,
                "classpath:/webapp/"
        );
    }
}
