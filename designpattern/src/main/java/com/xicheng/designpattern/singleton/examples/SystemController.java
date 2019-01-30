package com.xicheng.designpattern.singleton.examples;

import org.junit.Test;

/**
 * @author xichengxml
 * @date 2019/1/30 10:46
 * 没看懂
 */
public class SystemController {

    @Test
    public void test01() {
        SecurityManager securityManager = new SecurityManager();
        securityManager.checkCreateClassLoader();
        securityManager.checkAccept("localhost", 3306);
    }
}
