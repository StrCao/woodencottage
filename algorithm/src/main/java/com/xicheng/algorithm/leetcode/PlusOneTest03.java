package com.xicheng.algorithm.leetcode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xichengxml
 * @date 2018/12/24
 * @description
 */
public class PlusOneTest03 {

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        Pattern pattern = Pattern.compile("[9]+");
        Matcher matcher = pattern.matcher(Arrays.toString(digits));
        int[] result = new int[len];
        if (matcher.matches()) {
            result = new int[len + 1];
        }
        for (int i = len - 1; i >= 0; i--) {
            if (digits[len - 1] == 9) {
                result[len - 1] = 0;
            }
            if (digits[i] > 9) {
                result[i] = 0;
                digits[i]++;
            } else {
                result[i] = digits[i];
            }
        }

       return result;
    }

    public static void main(String[] args) {
        int[] input = {9,8,7,6,5,4,3,2,1,0};
        System.out.println(Arrays.toString(plusOne(input)));
    }
}
