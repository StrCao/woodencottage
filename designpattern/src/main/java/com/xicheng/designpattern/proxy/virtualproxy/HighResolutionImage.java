package com.xicheng.designpattern.proxy.virtualproxy;

import java.net.URL;

/**
 * @author xichengxml
 * @date 2019/1/30 11:30
 */
public class HighResolutionImage implements Image{

    private long startTime;
    private URL imgUrl;
    private int height;
    private int width;

    public HighResolutionImage(URL imgUrl) {
        this.startTime = System.currentTimeMillis();
        this.imgUrl = imgUrl;
        this.height = 600;
        this.width = 800;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isLoad() {
        // 延迟3秒加载图片
        return System.currentTimeMillis() - startTime > 3000;
    }
    @Override
    public void showImage() {
        System.out.println("Real image: " + imgUrl);
    }
}
