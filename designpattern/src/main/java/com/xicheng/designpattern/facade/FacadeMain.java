package com.xicheng.designpattern.facade;

import org.junit.Test;

/**
 * @author xichengxml
 * @date 2019/1/30 11:18
 */
public class FacadeMain {

    @Test
    public void test01() {
        Facade facade = new Facade();
        facade.watchTV();
    }
}
