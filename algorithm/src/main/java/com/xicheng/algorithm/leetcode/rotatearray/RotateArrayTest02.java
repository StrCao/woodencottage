package com.xicheng.algorithm.leetcode.rotatearray;

import java.util.Arrays;

/**
 * @author xichengxml
 * @date 2018/12/26
 * @description 超时
 */
public class RotateArrayTest02 {
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        if (length < 2) {
            return;
        }
        if (k > length) {
            k = k % length;
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int cnt = i + k;
            if (cnt > length - 1) {
                cnt = cnt % length;
            }
            result[cnt] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, length);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
    }
}
