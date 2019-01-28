package com.xicheng.framework.mybatis.demo.controller;

import com.google.gson.Gson;
import com.xicheng.framework.mybatis.demo.mapper.CustomerMapper;
import com.xicheng.framework.mybatis.demo.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author xichengxml
 * @date 2019/1/28 18:26
 */
@Controller
public class CustomerController {

    private static final Gson GSON = new Gson();

    @Autowired
    private CustomerMapper customerMapper;

    @RequestMapping("getAll")
    @ResponseBody
    public String getCostomer() {
        List<Customer> all = customerMapper.getAll();
        return GSON.toJson(all);
    }
}
