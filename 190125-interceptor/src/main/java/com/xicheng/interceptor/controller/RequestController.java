package com.xicheng.interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xichengxml
 * @date 2019/2/15 13:39
 */
@Controller
public class RequestController {

    @RequestMapping("/model")
    @ResponseBody
    public String returnModel() {
        System.out.println("debug");
        return "This is model";
    }
}
