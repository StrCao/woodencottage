package com.xicheng.newfeature.controller;

import org.junit.Test;

import java.util.Optional;

/**
 * @author xichengxml
 * @date 2019/1/2 11:29
 */
public class OptionalsController {

    @Test
    public void test01() {
        Optional<String> optional = Optional.of("input");
        optional.isPresent();
        optional.get();
        optional.orElse("default value");
        optional.ifPresent((s) -> System.out.println(s));
    }
}
