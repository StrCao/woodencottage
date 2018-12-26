package com.xicheng.algorithm.leetcode.largestpalindromeproduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author xichengxml
 * @date 2018/12/26
 * @description
 */
public class PalindromeTest01 {

    public static int largestPalindrome(int n) {
        int start = 0;
        int end = 0;
        int times = 1;
        for (int i = 1; i < n; i++) {
            times *= 10;
        }
        start = times;
        end = times * 10 - 1;
        long production = 0;
        String result = null;
        long tmp = 0;
        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                production = i * j;
                result = production + "";
                String resultRev = new StringBuilder(result).reverse().toString();
                if (result.equals(resultRev)) {
                    tmp = production;
                    System.out.println(tmp);
                }
            }
        }
        return (int)tmp % 1337;
    }

    public static void main(String[] args) {
        System.out.println(largestPalindrome(3));
    }
}
