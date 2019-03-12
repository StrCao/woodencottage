package com.xicheng.chatdemo.controller;

import com.xicheng.chatdemo.common.SubscribeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xichengxml
 * @date 2019/3/12 15:58
 */
@Controller
public class SubscribeController {

    @Autowired
    private SubscribeProxy subscribeProxy;

    @RequestMapping("/")
    @ResponseBody
    public String init() {
        subscribeProxy.init();
        return "success";
    }
}
