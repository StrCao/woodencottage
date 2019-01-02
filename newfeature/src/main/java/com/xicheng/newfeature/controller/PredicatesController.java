package com.xicheng.newfeature.controller;

import com.xicheng.newfeature.util.PrintUtil;
import org.junit.Test;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author xichengxml
 * @date 2019/1/2
 * @description
 */
public class PredicatesController {

    @Test
    public void test01() {
        Predicate<String> predicate = (input) -> input.length() > 0;
        boolean test01 = predicate.test("input");
        boolean test02 = predicate.negate().test("input");
        System.out.println(test01 + "--" + test02);
    }

    @Test
    public void test02() {
        Predicate<Boolean> notNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;
        boolean test01 = notNull.test(false);
        boolean test02 = isNull.test(false);
        PrintUtil.print(test01, test02);
    }

    @Test
    public void test03() {
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> notEmpty = isEmpty.negate();
        boolean test01 = isEmpty.test("input");
        boolean test02 = notEmpty.test("input");
        PrintUtil.print(test01, test02);
    }
}
