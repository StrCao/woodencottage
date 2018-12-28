package com.xicheng.javase.exception.controller;

import com.xicheng.javase.exception.common.MyException;
import com.xicheng.javase.exception.service.ExceptionService;
import com.xicheng.javase.exception.service.impl.ExceptionServiceImpl;
import org.junit.Test;

/**
 * @author xichengxml
 * @date 2018/12/27
 * @description
 */
public class ExceptionController {

    @Test
    public void test01() {
        ExceptionService exceptionService = new ExceptionServiceImpl();
        try {
            exceptionService.test01("a");
            Thread.sleep(100);
            exceptionService.test01("quit");
        } catch (MyException e) {
            System.out.println(e.getInput() + e);
            // e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
