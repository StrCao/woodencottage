package com.xicheng.datastructure;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author xichengxml
 * @date 2018/12/19
 * @description
 */
public class NumbericTest {

    @Test
    public void test01() {
        String str = "0.013242";
        boolean numeric = StringUtils.isNumeric(str);
        System.out.println(numeric);
    }
}
