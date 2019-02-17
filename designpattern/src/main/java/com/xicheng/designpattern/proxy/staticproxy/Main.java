package com.xicheng.designpattern.proxy.staticproxy;

public class Main {

    public static void main(String[] args) {
        RealStar realStar = new RealStar();
        ProxyStar proxyStar = new ProxyStar(realStar);

        proxyStar.signContract();
        proxyStar.sing();
        proxyStar.collectMoney();
    }
}
