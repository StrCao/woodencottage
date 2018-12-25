package com.xicheng.algorithm.leetcode.countandsay;

/**
 * @author xichengxml
 * @date 2018/12/25
 * @description
 */
public class CountAndSayTest01 {

    public String countAndSay(int n) {
        String str = null;
        if (n == 1) {
            str = "1";
        } else {
            str = countAndSay(n - 1);
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
