package com.xicheng.designpattern.factory.simplefactory02;

import com.xicheng.designpattern.factory.common.Car;

public class Client03 {

    public static void main(String[] args) {
        Car audi = SimpleFactory02.createAudi();
        Car benz = SimpleFactory02.createBenz();

        audi.run();
        benz.run();
    }
}
