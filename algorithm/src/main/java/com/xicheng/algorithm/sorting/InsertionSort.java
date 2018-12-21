package com.xicheng.algorithm.sorting;

/**
 * @author xichengxml
 * @date 2018/12/21
 * @description
 */
public class InsertionSort {

    public static void main(String[] args) {
        Comparable<Integer>[] arr = Common.ARR;
        int N = Common.LEN;
        // sort arr to increasing order
        for (int i = 1; i < N; i++) {
            // insert arr[i] among arr[i-1],arr[i-2],arr[i-3]
            for (int j = i; j > 0 && Common.less(arr[j], arr[j-1]); j--) {
                Common.exch(arr, j, j-1);
            }
        }
        Common.show(arr);
    }
}
