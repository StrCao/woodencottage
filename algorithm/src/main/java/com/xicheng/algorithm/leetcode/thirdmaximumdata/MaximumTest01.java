package com.xicheng.algorithm.leetcode.thirdmaximumdata;

import java.util.Arrays;

/**
 * @author xichengxml
 * @date 2018/12/26
 * @description
 */
public class MaximumTest01 {
    public static int thirdMax(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int max = nums[0] > nums[1] ? nums[0] : nums[1];
        if (length == 2) {
            return max;
        }
        Arrays.sort(nums);
        int cnt = 0;
        int result = 0;
        for (int i = length - 1; i > 0; i--) {
            if (nums[i] != nums[i - 1]) {
                cnt++;
            }
            if (cnt == 3) {
                result = nums[i];
                break;
            }
            result = nums[0];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1};
        System.out.println(thirdMax(nums));
    }
}
