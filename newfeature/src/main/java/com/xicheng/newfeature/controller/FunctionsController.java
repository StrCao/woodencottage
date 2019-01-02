package com.xicheng.newfeature.controller;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author xichengxml
 * @date 2019/1/2
 * @description
 */
public class FunctionsController {

    @Test
    public void test01() {
        Function<String, Integer> strToInt = Integer::valueOf;
        Function<String, String> intToStr = strToInt.andThen(String::valueOf);
        String apply = intToStr.apply("1");
        System.out.println(apply);
    }
}
