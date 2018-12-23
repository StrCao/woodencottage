package com.xicheng.designpattern.factory.simplefactory01;

import com.xicheng.designpattern.factory.common.Audi;
import com.xicheng.designpattern.factory.common.Benz;
import com.xicheng.designpattern.factory.common.Car;

public class SimpleFactory01 {

    public static Car createCar(String type){
        if ("Audi".equals(type)) {
            return new Audi();
        } else if ("Benz".equals(type)) {
            return new Benz();
        } else {
            return null;
        }
    }
}
