package com.xicheng.algorithm.leetcode.additivenumber;

import org.junit.Test;

/**
 * @author xichengxml
 * @date 2018/12/28
 * @description 输入111会报错
 */
public class AdditiveNumberTest02 {

    public static boolean isAdditiveNumber(String num) {
        int length = num.length();
        if (length < 3) {
            return false;
        }
        int cnt01 = 1;
        int cnt02 = 1;
        String subString = "";
        long add01 = 0;
        long add02 = 0;
        long sum = 0;
        for (int i = 1; i < length; i++) {
            if (i + cnt02 >= length) {
                if (subString.startsWith(sum + "")) {
                    return true;
                }
                if ((add01 + "").length() + (add02 + "").length() >= length) {
                    return false;
                }
                continue;
            }
            String str01 = num.substring(0, i);
            if (str01.startsWith("0")) {
                continue;
            }
            add01 = Long.parseLong(str01);
            for (int j = i; j < length; j++) {
                if (j + cnt02 >= length - 1) {
                    if (subString.startsWith(sum + "")) {
                        return true;
                    }
                    break;
                }
                String str02 = num.substring(j, j + cnt02);
                if (str02.startsWith("0")) {
                    continue;
                }
                add02 = Long.parseLong(str02);
                sum = add01 + add02;
                subString = num.substring(j + cnt02);
                if (subString.startsWith(sum + "")) {
                    add01 = add02;
                    continue;
                }
                cnt02++;
            }
            cnt02 = 1;
        }
        return false;
    }

    public static void main(String[] args) {
        String numSequence = "199100199";
        String numSequence2 = "112358";
        String numSequence3 = "112358";
        System.out.println(isAdditiveNumber(numSequence));
    }

    @Test
    public void test01() {
        String num = "1991001990";
        int length = num.length();
        int cnt = 0;
        for (int i = 1; i <= length; i++) {
            String string01 = num.substring(0, i);
            long add01 = Long.parseLong(string01);
            for (int j = i + 1; j <= length; j++) {
                String string02 = num.substring(i, j);
                long add02 = Long.parseLong(string02);
                String substring = num.substring(j);
                long sum = add01 + add02;
                if (substring.startsWith(sum + "")) {
                    do {
                        int len = (add01 + "").length();
                        cnt += len;
                        add01 = add02;
                        add02 = sum;
                        String addStr01 = add01 + "";
                        String addStr02 = add02 + "";
                        if (addStr01.startsWith("0") || addStr02.startsWith("0")) {
                            continue;
                        }
                        sum = add01 + add02;
                        int len2 = addStr02.length();
                        if (cnt + len2 + (sum + "").length() >= length) {
                            System.out.println(add01 +"--" + add02 + "--" + sum + "--" + i + "--" + j);
                            System.out.println("true");
                            return; // true
                        }
                        substring = num.substring(len + len2);
                    } while (!substring.startsWith(sum + ""));
                }

            }
        }
        System.out.println("false");
        return;
    }

    @Test
    public void test02() {
        String num = "19910";
        int length = num.length();
        int cnt = 1;
        for (int i = 1; i <= length; i++) {
            System.out.println("add01:" + num.substring(0, i));
            for (int j = i + 1; j <= length; j++) {
                System.out.println("add02:" + num.substring(i, j));
            }
        }
    }
}
