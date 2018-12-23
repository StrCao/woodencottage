package com.xicheng.designpattern.factory.simplefactory01;

import com.xicheng.designpattern.factory.common.Car;

public class Client02 {

    public static void main(String[] args) {
        Car audi = SimpleFactory01.createCar("Audi");
        Car benz = SimpleFactory01.createCar("Benz");

        audi.run();
        benz.run();
    }
}
