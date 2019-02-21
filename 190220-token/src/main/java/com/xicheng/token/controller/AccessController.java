package com.xicheng.token.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author xichengxml
 * @date 2019/2/20 16:16
 */
@Controller
@Slf4j
public class AccessController {

    @RequestMapping(value = "/access", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String access(HttpServletRequest request) {
        String body = (String) request.getAttribute("body");
        return body;
    }

    @RequestMapping("/token")
    @ResponseBody
    public String getToken() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }

}
