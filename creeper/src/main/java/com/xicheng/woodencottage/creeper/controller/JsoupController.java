package com.xicheng.woodencottage.creeper.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @author xichengxml
 * @date 2018/12/19
 * @description
 */
@Controller
public class JsoupController {

    @RequestMapping("/test01")
    public void test01() {
        try {
            Document document = Jsoup.connect("http://www.baidu.com").get();
            System.out.println(document.title());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
