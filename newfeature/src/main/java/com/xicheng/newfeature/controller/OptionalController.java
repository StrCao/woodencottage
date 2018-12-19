package com.xicheng.newfeature.controller;

import java.util.Optional;

/**
 * @author xichengxml
 * @date 2018/12/17
 * @description
 */
public class OptionalController {


    public void test01() {
        Optional<Integer> a = Optional.of(1);
        System.out.println(a.orElse(new Integer(10)));
    }

    public void test02() {
        String string = null;
        String s = Optional.ofNullable(string).map(str -> str.substring(1)).orElse("null");
        System.out.println(s);
    }
}
