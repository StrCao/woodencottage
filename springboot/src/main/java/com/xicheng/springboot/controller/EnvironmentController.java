package com.xicheng.springboot.controller;

import com.xicheng.springboot.config.EnvironmentConfig;
import com.xicheng.springboot.config.XMLConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xichengxml
 * @date 2018/12/19
 * @description
 */
@Controller
public class EnvironmentController {

    @Autowired
    private EnvironmentConfig environmentConfig;
    @Autowired
    private XMLConfiguration xmlConfiguration;
    @Value("${environment.empty}")
    private String empty;

    @RequestMapping("test01")
    @ResponseBody
    public String test01() {
        String env = environmentConfig.getGlobalVal() + "-env-" + environmentConfig.getLocalVal();
        String xml = xmlConfiguration.getGlobalVal() + "-xml-" + xmlConfiguration.getLocalVal();
        return env + xml + empty;
    }
}
