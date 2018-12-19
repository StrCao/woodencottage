package com.xicheng.newfeature.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author xichengxml
 * @date 2018/12/17
 * @description
 */
public class StreamController {

    /**
     * stream()--为集合创建串行流
     * parallelStream()--为集合创建并行流
     */

    public void test01() {
        List<String> stringList = Arrays.asList("001", "", "002", "", "003");
        List<String> result = stringList.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        result.forEach(System.out::println);
    }


    public void test02() {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }


    public void test03() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 5);
        integerList.stream().map(i -> i * i).distinct().forEach(System.out::println);
    }
}
