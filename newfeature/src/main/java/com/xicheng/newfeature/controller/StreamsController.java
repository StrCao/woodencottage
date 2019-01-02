package com.xicheng.newfeature.controller;

import com.xicheng.newfeature.util.PrintUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author xichengxml
 * @date 2019/1/2 13:26
 */
public class StreamsController {
    private static List<String> strList = new ArrayList<>();
    private static Stream<String> result;
    @Before
    public void before() {
        Collections.addAll(strList, "d2", "a1", "c3", "b4", "b3", "c4", "a2", "d1");
    }

    @Test
    // filter
    public void test01() {
        result = strList.stream().filter((s -> s.startsWith("a")));
    }

    @Test
    // sorted
    public void test02() {
        result = strList.stream().sorted().filter((s -> s.startsWith("d")));
    }

    @Test
    // map
    public void test03() {
        result = strList.stream().map(String::toUpperCase).sorted((a, b) -> b.compareTo(a));
    }

    @Test
    // match
    public void test04() {
        boolean anyMatch = strList.stream().anyMatch((s) -> s.startsWith("a"));
        boolean allMatch = strList.stream().allMatch((s -> s.startsWith("a")));
        boolean noneMatch = strList.stream().noneMatch((s -> s.startsWith("z")));
        PrintUtil.print(anyMatch, allMatch, noneMatch);
    }

    @Test
    // count
    public void test05() {
        long count = strList.stream().filter((s -> s.startsWith("a"))).count();
        PrintUtil.print(count);
    }

    @Test
    // reduce
    public void test06() {
        Optional<String> reduce = strList.stream().sorted().reduce((a, b) -> a + "#" + b);
        PrintUtil.print(reduce);
    }

    @Test
    // distinct
    public void test07() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 5);
        integerList.stream().map(i -> i * i).distinct().forEach(System.out::println);
    }
    @After
    public void after() {
        if (result != null) {
            result.forEach(System.out::println);
        }
    }
}
