package com.xicheng.algorithm.leetcode.additivenumber;

import java.math.BigInteger;

/**
 * @author xichengxml
 * @date 2018/12/28
 * @description 输入111会报错
 */
public class AdditiveNumberTest01 {

    public static boolean isAdditiveNumber(String num) {
        int length = num.length();
        if (length < 3) {
            return false;
        }
        int cnt01 = 1;
        int cnt02 = 1;
        String subString = "";
        for (int i = 0; i < length; i++) {
            if (i + cnt01 >= length) {
                return true;
            }
            String str01 = num.substring(i, i + cnt01);
            if (str01.startsWith("0")) {
                continue;
            }
            long add01 = Long.parseLong(str01);
            for (int j = i + cnt01; j < length; j++) {
                if (j + cnt02 >= length) {
                    return true;
                }
                String str02 = num.substring(j, j + cnt02);
                if (str02.startsWith("0")) {
                    continue;
                }
                long add02 = Long.parseLong(str02);
                long sum = add01 + add02;
                subString = num.substring(j + cnt02);
                if (subString.startsWith(sum + "")) {
                    continue;
                }
                cnt02++;
            }
            cnt01++;
        }
        return true;
    }

    public static void main(String[] args) {
        String numSequence = "111";
        System.out.println(isAdditiveNumber(numSequence));
    }
}
