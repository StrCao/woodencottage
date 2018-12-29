package com.xicheng.newfeature.lambda;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author xichengxml
 * @date 2018/12/29
 */
public class LambdaTest01 {

    private static List<String> nameList;
    @Before
    public void before() {
        nameList = Arrays.asList("test02", "test01", "test04", "test03");
    }

    @After
    public void after() {
        nameList.forEach(System.out::println);
    }

    @Test
    public void test01() {
        Collections.sort(nameList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    @Test
    public void test02() {
        Collections.sort(nameList, (String a, String b) -> {
            return a.compareTo(b);
        });
    }

    @Test
    public void test03() {
        Collections.sort(nameList, (String a, String b) -> a.compareTo(b));
    }

    @Test
    public void test04() {
        Collections.sort(nameList, (a, b) -> a.compareTo(b));
    }

}
