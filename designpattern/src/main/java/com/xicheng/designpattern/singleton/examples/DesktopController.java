package com.xicheng.designpattern.singleton.examples;

import org.junit.Test;

import java.awt.*;
import java.net.URI;

/**
 * @author xichengxml
 * @date 2019/1/30 10:39
 * 采用的是sychronized加锁getDesktop方法，然后判断是否已存在的方式
 */
public class DesktopController {

    @Test
    public void test01() throws Exception {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI("www.baidu.com"));
    }
}
