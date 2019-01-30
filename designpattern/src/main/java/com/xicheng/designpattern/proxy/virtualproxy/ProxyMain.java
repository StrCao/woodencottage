package com.xicheng.designpattern.proxy.virtualproxy;

import org.junit.Test;

import java.net.URL;

/**
 * @author xichengxml
 * @date 2019/1/30 13:16
 */
public class ProxyMain {

    @Test
    public void test01() throws Exception{
        URL imageUrl = new URL("http://localhost/img.jpg");
        HighResolutionImage highResolutionImage = new HighResolutionImage(imageUrl);
        ProxyImage proxyImage = new ProxyImage(highResolutionImage);
        proxyImage.showImage();
    }
}
