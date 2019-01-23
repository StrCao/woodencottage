package com.xicheng.database;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xichengxml
 * @date 2019/1/22 16:23
 */
public class TestPattern {

    @Test
    public void test01() {
        Pattern pattern = Pattern.compile("[0-9a-zA-Z]+$");
        String str01 = "test01";
        String str02 = "01test";
        String str03 = "te01st";
        Matcher matcher01 = pattern.matcher(str01);
        Matcher matcher02 = pattern.matcher(str02);
        Matcher matcher03 = pattern.matcher(str03);
        System.out.println(matcher01.matches());
        System.out.println(matcher02.matches());
        System.out.println(matcher03.matches());
    }
}
