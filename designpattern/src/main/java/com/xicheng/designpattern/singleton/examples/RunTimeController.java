package com.xicheng.designpattern.singleton.examples;

import org.junit.Test;

/**
 * @author xichengxml
 * @date 2019/1/30 10:33
 *
 * RunTime为单例，采用的是饿汉式
 */
public class RunTimeController {

    @Test
    public void test01() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
    }
}
