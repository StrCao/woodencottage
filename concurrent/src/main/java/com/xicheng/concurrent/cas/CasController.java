package com.xicheng.concurrent.cas;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author xichengxml
 * @date 2018/12/24
 * @description
 */
public class CasController {
    /**
     * 如果static会怎样
     */
    private boolean locked = false;

    /**
     * 多线程不安全
     * @return
     */
    public boolean lock01() {
        if (!locked) {
            locked = true;
            return true;
        }
        return false;
    }

    /**
     * 使用sychronized关键字实现多线程安全
     * @return
     */
    public synchronized boolean lock02() {
        if (!locked) {
            locked = true;
            return true;
        }
        return false;
    }

    /**
     * 使用CAS算法实现多线程安全
     * @return
     */
    public boolean lock03() {
        AtomicBoolean lock = new AtomicBoolean(false);
        return lock.compareAndSet(false, true);
    }
}
