package com.xicheng.framework.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @author xichengxml
 * @date 2019/1/28 16:12
 * 该实例用aop实现的统计方法执行时间，MethodTimeService是切点对象，MethodTimeAdvice是
 */

@Controller
public class MethodTimeController {

    @Autowired
    private MethodTimeService methodTimeService;

    @RequestMapping("/getTime")
    @ResponseBody
    public String getTime() {
        methodTimeService.test01();
        return "success";
    }

}
