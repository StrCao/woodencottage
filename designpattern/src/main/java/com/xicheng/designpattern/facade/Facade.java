package com.xicheng.designpattern.facade;

/**
 * @author xichengxml
 * @date 2019/1/30 11:17
 */
public class Facade {

    private SubSystem subSystem = new SubSystem();

    public void watchTV() {
        subSystem.turnOnYourTV();
        subSystem.selectChannel();
        subSystem.watchProgram();
    }
}
