package com.xicheng.designpattern.proxy.staticproxy;

public class RealStar implements Star {
    @Override
    public void signContract() {
        System.out.println("RealStar.signContract");
    }

    @Override
    public void sing() {
        System.out.println("RealStar.sing");
    }

    @Override
    public void collectMoney() {
        System.out.println("RealStar.collectMoney");
    }
}
