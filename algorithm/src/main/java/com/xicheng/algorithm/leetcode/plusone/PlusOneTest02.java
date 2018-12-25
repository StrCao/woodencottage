package com.xicheng.algorithm.leetcode.plusone;

import java.util.Arrays;

/**
 * @author xichengxml
 * @date 2018/12/24
 * @description
 */
public class PlusOneTest02 {

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] result = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                result[i] = digits[i] + 1;
            } else {
                result[i] = digits[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 末位为9可能发生进位
        int[] input = {9};
        System.out.println(Arrays.toString(plusOne(input)));
    }
}
