package com.xicheng.algorithm.leetcode.removeelement;

import java.util.Arrays;

/**
 * @author xichengxml
 * @date 2018/12/25
 * @description
 */
public class RemoveElementTest01 {
    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        if (length == 1 && nums[0] == val) {
            return 0;
        }
        int tmp = 0;
        int cnt = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                for (int j = i; j < length - 1; j++) {
                    tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
                cnt++;
            }
        }
        return nums.length - cnt;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 2, 2};
        int val = 3;
        int len = removeElement(nums, val);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
