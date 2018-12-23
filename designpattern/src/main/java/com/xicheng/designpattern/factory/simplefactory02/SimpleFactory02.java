package com.xicheng.designpattern.factory.simplefactory02;

import com.xicheng.designpattern.factory.common.Audi;
import com.xicheng.designpattern.factory.common.Benz;
import com.xicheng.designpattern.factory.common.Car;

public class SimpleFactory02 {

    public static Car createAudi() {
        return new Audi();
    }

    public static Car createBenz() {
        return new Benz();
    }
}
