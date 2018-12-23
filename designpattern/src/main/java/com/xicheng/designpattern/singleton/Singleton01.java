package com.xicheng.designpattern.singleton;

public class Singleton01 {

    private static final Singleton01 instance = new Singleton01();

    private Singleton01() {
    }

    public static Singleton01 getInstance() {
        return instance;
    }
}
