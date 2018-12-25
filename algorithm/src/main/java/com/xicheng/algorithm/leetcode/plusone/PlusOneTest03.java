package com.xicheng.algorithm.leetcode.plusone;

import java.util.Arrays;

/**
 * @author xichengxml
 * @date 2018/12/24
 * @description
 */
public class PlusOneTest03 {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n+1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args) {
        int[] input = {2,9};
        System.out.println(Arrays.toString(plusOne(input)));
    }
}
