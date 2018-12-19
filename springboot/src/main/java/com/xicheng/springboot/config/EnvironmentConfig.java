package com.xicheng.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author xichengxml
 * @date 2018/12/19
 * @description
 */
@Configuration
public class EnvironmentConfig {

    @Value("${environment.global}")
    @Setter
    @Getter
    private String globalVal;

    @Value("${environment.mode}")
    @Getter
    @Setter
    private String localVal;
}
