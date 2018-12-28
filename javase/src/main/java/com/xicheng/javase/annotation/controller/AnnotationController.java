package com.xicheng.javase.annotation.controller;

import com.xicheng.javase.annotation.common.MyAnnotation;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author xichengxml
 * @date 2018/12/27
 * @description
 */
public class AnnotationController {

    @Test
    public void test01() throws Exception{
        Class<?> loadClass = AnnotationController.class.getClassLoader().loadClass("com.xicheng.javase.annotation.service.impl.AnnotationServiceImpl");
        Method[] methods = loadClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Annotation[] declaredAnnotations = methods[i].getDeclaredAnnotations();
            for (int j = 0; j < declaredAnnotations.length; j++) {
                System.out.println(declaredAnnotations);
            }
            if (methods[i].isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = methods[i].getAnnotation(MyAnnotation.class);
                int anInt = annotation.getInt();
                String string = annotation.getString();
                System.out.println(anInt + ":" + string);
            }
        }
    }
}
