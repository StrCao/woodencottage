package com.xicheng.listener.controller;

import com.xicheng.listener.listener.MySessionListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xichengxml
 * @date 2019/2/15 14:51
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public String login(String userName, HttpServletRequest request) {
        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute(userName, userName);
        AtomicInteger userCount = MySessionListener.userCount;
        return userName + "上线成功！当前在线人数： " + userCount;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(String userName, HttpServletRequest request) {
        HttpSession httpSession = request.getSession(true);
        httpSession.removeAttribute(userName);
        httpSession.invalidate();
        AtomicInteger userCount = MySessionListener.userCount;
        return userName + "下线成功！当前在线人数：" + userCount;
    }
}
