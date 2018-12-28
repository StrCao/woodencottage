package com.xicheng.javase.exception.service.impl;

import com.xicheng.javase.exception.service.ExceptionService;
import com.xicheng.javase.exception.common.MyException;

/**
 * @author xichengxml
 * @date 2018/12/27
 * @description
 */
public class ExceptionServiceImpl implements ExceptionService{

    @Override
    public void test01(String string) throws MyException{
        switch (string) {
            case "a":
                System.out.println("This is a");
                break;
            case "quit":
                throw new MyException("你确定要退出吗?", string);
            default:
                System.out.println("This is null");
        }
    }
}
