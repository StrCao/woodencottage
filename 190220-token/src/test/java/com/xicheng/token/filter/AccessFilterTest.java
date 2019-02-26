package com.xicheng.token.filter;

import org.junit.Test;

/**
 * @author xichengxml
 * @date 2019/2/21 17:06
 */
public class AccessFilterTest {

    @Test
    public void test01() {
        System.out.println("{}".length());
    }

    @Test
    public void test02() {
        String str01 = "1";
        int num1 = Integer.parseInt(str01);
        System.out.println(num1);
        String str02 = "a";

        try {
            System.out.println(Integer.parseInt(str02));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        String str03 = "";
        try {
            System.out.println(Integer.parseInt(str03));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
