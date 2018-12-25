package com.xicheng.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author xichengxml
 * @date 2018/12/24
 * @description
 */
public class PlusOneTest01 {

    public static int[] plusOne(int[] digits) {
        int num = 0;
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            int tmp = 1;
            for (int j = 0; j < len - 1 - i; j++) {
                tmp *= 10;
            }
            num += digits[i] * tmp;
        }
        // 可能会越界
        num = num + 1;
        String s = num + "";
        int strLen = s.length();
        int[] result = new int[strLen];
        for (int i = strLen - 1; i >= 0; i--) {
            result[i] = num % 10;
            num = num / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {9,8,7,6,5,4,3,2,1,0};
        System.out.println(Arrays.toString(plusOne(input)));
    }
}
