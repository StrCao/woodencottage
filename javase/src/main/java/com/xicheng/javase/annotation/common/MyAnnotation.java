package com.xicheng.javase.annotation.common;

import java.lang.annotation.*;

/**
 * @author xichengxml
 * @date 2018/12/27
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface MyAnnotation {

    int getInt() default 1;

    String getString();

}
