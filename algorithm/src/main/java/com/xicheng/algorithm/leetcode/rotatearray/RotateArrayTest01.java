package com.xicheng.algorithm.leetcode.rotatearray;

import java.util.Arrays;

/**
 * @author xichengxml
 * @date 2018/12/26
 * @description 超时
 */
public class RotateArrayTest01 {
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        if (length < 2) {
            return;
        }
        if (k > length) {
            k = k % length;
        }
        int tmp = 0;
        while (k > 0) {
            for (int i = length - 1; i > 0; i--) {
                tmp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = tmp;
            }
            k--;
        }
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
    }
}
