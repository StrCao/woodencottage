package com.xicheng.newfeature.util;

import java.util.Collections;
import java.util.Objects;

/**
 * @author xichengxml
 * @date 2019/1/2
 * @description
 */
public class PrintUtil {

    public static void print(Object... inputs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object input: inputs) {
            stringBuilder.append(input).append("--");
        }
        System.out.println(stringBuilder.toString());
    }
}
