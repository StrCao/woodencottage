package com.xicheng.designpattern.facade;

/**
 * @author xichengxml
 * @date 2019/1/30 11:13
 */
public class SubSystem {

    public void turnOnYourTV() {
        System.out.println("Turn on your TV with remote controller");
    }

    public void selectChannel() {
        System.out.println("Select your favorite channel");
    }

    public void watchProgram() {
        System.out.println("Watch your favorite program");
    }
}
