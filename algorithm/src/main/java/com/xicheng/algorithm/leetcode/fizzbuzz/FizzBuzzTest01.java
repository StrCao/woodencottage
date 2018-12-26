package com.xicheng.algorithm.leetcode.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xichengxml
 * @date 2018/12/26
 * @description
 */
public class FizzBuzzTest01 {

    public static List<String> fizzBuzz(int n) {
        List<String> stringList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                stringList.add("FizzBuzz");
            } else if (i % 3 == 0) {
                stringList.add("Fizz");
            } else if (i % 5 == 0) {
                stringList.add("Buzz");
            } else {
                stringList.add(i + "");
            }
        }
        return stringList;
    }

    public static void main(String[] args) {
        List<String> stringList = fizzBuzz(15);
        stringList.stream().forEach(System.out::println);
    }
}
