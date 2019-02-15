package com.xicheng.filter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xichengxml
 * @date 2019/2/15 14:31
 */
@Controller
public class RequestController {

    @RequestMapping("/model")
    @ResponseBody
    public String returnModel() {
        return "This is model";
    }
}
