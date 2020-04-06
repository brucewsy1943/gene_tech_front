package com.genetech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MVCConfiguration extends WebMvcConfigurationSupport {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //template/index/index---------不行
        //forward:/template/index/index.html----默认是static目录下-------不行
        registry.addViewController("/").setViewName("forward:/template/index/index");

        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);

        super.addViewControllers(registry);

    }
}
