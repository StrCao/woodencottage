package com.xicheng.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xichengxml
 * @date 2018/12/24
 * @description
 */
public class AtomicIntrgerController {

    public void testInteger() {
        AtomicInteger num = new AtomicInteger(0);
        num.getAndIncrement();
    }
}
