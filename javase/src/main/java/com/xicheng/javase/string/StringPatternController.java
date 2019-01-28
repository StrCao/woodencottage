package com.xicheng.javase.string;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author xichengxml
 * @date 2019/1/28 13:41
 * 看到这样一段代码，不解，自测一下
 * <code>
 * if(key==null) key="";
 * // 2016年9月6日09:49:48 修复此问题，不加-1 如果最后为分隔符时将被忽略
 * String[] s = key.split(",",-1);
 * </code>
 */
public class StringPatternController {

    /**
     * 首先看看切割null会返回啥，哦，有点傻了，这特么是很明显的空指针
     */
    @Test
    public void test01() {
        String str = null;
        String[] split = str.split(",");
        Stream.of(split).forEach(System.out::println);
    }

    /**
     * 切一个正常点的试试，貌似切完有空格
     */
    @Test
    public void test02() {
        String str = "1, 2, 3";
        String[] split = str.split(",");
        Stream.of(split).forEach(System.out::println);
    }

    /**
     * 切一个最后为分隔符的，没看出区别
     */
    @Test
    public void test03() {
        String str = "1, 2, 3, ,";
        String[] split = str.split(",");
        Stream.of(split).forEach(System.out::println);
        System.out.println("----------------------");
        String[] split1 = str.split(",", -1);
        Stream.of(split1).forEach(System.out::println);
    }

}
