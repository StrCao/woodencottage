package com.xicheng.javase.annotation.service.impl;

import com.xicheng.javase.annotation.common.MyAnnotation;
import com.xicheng.javase.annotation.service.AnnotationService;

/**
 * @author xichengxml
 * @date 2018/12/27
 * @description
 */
public class AnnotationServiceImpl implements AnnotationService {

    @Override
    @MyAnnotation(getInt = 1, getString = "test")
    public void test01() {
        System.out.println("I am invoked");
    }
}
