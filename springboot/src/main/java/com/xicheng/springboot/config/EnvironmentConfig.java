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
    private String globalVal;

    @Value("${environment.mode}")
    private String localVal;

    public String getGlobalVal() {
        return globalVal;
    }

    public void setGlobalVal(String globalVal) {
        this.globalVal = globalVal;
    }

    public String getLocalVal() {
        return localVal;
    }

    public void setLocalVal(String localVal) {
        this.localVal = localVal;
    }
}
