package com.xicheng.newfeature.functionalinterface;

import org.junit.Test;

/**
 * @author xichengxml
 * @date 2018/12/29
 */
public class FunctionalTest01 {

    @Test
    public void test01() {
        Converter<String, Integer> converter = (from -> Integer.valueOf(from));
        Integer num = converter.convert("123");
        System.out.println(num);
    }

    @Test
    public void test02() {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);
    }

    @Test
    public void test03() {
        Something something = new Something();
        Converter<String, String> converter = something::startWith;
        String string = "java";
        converter.convert(string);
    }

    interface Converter<F, T> {
        T convert(F from);
    }

    class Something {
        String startWith(String string) {
            return String.valueOf(string.charAt(0));
        }
    }
}
