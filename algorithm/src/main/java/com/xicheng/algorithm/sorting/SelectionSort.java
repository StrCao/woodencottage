package com.xicheng.algorithm.sorting;


public class SelectionSort {

    public static void main(String[] args) {
        Comparable<Integer>[] arr = Common.ARR;
        int N = Common.LEN;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (Common.less(arr[j], arr[min])) {
                    min = j;
                }
            }
            Common.exch(arr, i, min);
        }
        Common.show(arr);
    }
}
