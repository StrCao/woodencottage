package com.xicheng.crossorigin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xichengxml
 * @date 2019/2/18 10:20
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test01").setViewName("test01");
        registry.addViewController("/test02").setViewName("test02");
        registry.addViewController("/test03").setViewName("test03");
        registry.addViewController("/test04").setViewName("test04");
        registry.addViewController("/test05").setViewName("test05");
    }
}
