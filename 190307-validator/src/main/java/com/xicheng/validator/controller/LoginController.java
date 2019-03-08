package com.xicheng.validator.controller;

import com.google.gson.Gson;
import com.xicheng.validator.entity.LoginMsg;
import com.xicheng.validator.response.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @author xichengxml
 * @date 2019/3/7 17:16
 */
@Controller
public class LoginController {

    private static final Gson GSON = new Gson();

    @RequestMapping("/login")
    @ResponseBody
    public String login(@Valid LoginMsg loginMsg, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                return GSON.toJson(new ResponseResult(error.getDefaultMessage(), "errorBody"));
            }
        }
        return GSON.toJson(new ResponseResult("success", "successBody"));
    }
}
