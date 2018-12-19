package com.xicheng.algorithm.sorting;


public class SelectionSort {

    public static void main(String[] args) {
        Comparable<Integer>[] arr = new Comparable[]{1, 3, 5, 6, 4, 2};
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (Common.less(arr[j], arr[min])) {
                    min = j;
                }
            }
            Common.exch(arr, i, min);
        }
        Common.show(arr);
    }
}
