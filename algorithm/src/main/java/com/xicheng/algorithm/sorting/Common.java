package com.xicheng.algorithm.sorting;

import java.util.Arrays;

/**
 *
 */
public class Common {

    public static final Comparable<Integer>[] ARR = new Comparable[]{1, 3, 5, 6, 4, 2};
    public static final int LEN = ARR.length;
    /**
     * 实际排序算法
     * @param arr
     */
    public static void sort(Comparable[] arr){

    }

    /**
     * 小于
     * @param u
     * @param v
     * @return
     */
    public static boolean less(Comparable u, Comparable v) {
        return u.compareTo(v) < 0;
    }

    /**
     * 数据交换
     * @param arr
     * @param i
     * @param j
     */
    public static void exch(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    /**
     * 打印
     * @param arr
     */
    public static void show(Comparable[] arr) {
        Arrays.stream(arr).forEach(System.out::println);
    }

    /**
     * 是否有序
     * @param arr
     * @return
     */
    public static boolean isSorted(Comparable[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if (less(arr[i], arr[i + 1])) {
                return false;
            }
        }
        return true;
    }
}
