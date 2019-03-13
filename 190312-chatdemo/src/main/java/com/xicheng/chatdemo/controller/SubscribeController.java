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

    @RequestMapping("/sub01")
    @ResponseBody
    public String client01() {
        subscribeProxy.init("mychannel01");
        return "success";
    }

    @RequestMapping("/sub02")
    @ResponseBody
    public String client02() {
        subscribeProxy.init("mychannel02");
        return "success";
    }
}
