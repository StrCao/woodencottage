package com.xicheng.newfeature.interfaces;

/**
 * @author xichengxml
 * @date 2018/12/29
 * @description
 */
public interface ITest01 {

    default void test01() {
        System.out.println("This is method test01 in interface ITest01");
    }
}
