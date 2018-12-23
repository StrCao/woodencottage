package com.xicheng.designpattern.factory.withoutfactory;

import com.xicheng.designpattern.factory.common.Audi;
import com.xicheng.designpattern.factory.common.Benz;
import com.xicheng.designpattern.factory.common.Car;
import org.junit.Test;

public class Client01 {

    public static void main(String[] args) {
        Car audi = new Audi();
        Car benz = new Benz();

        audi.run();
        benz.run();
    }
}
