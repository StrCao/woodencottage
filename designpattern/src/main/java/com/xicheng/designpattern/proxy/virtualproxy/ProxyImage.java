package com.xicheng.designpattern.proxy.virtualproxy;

/**
 * @author xichengxml
 * @date 2019/1/30 13:12
 */
public class ProxyImage implements Image {

    private HighResolutionImage highResolutionImage;

    public ProxyImage(HighResolutionImage highResolutionImage) {
        this.highResolutionImage = highResolutionImage;
    }

    @Override
    public void showImage() {
        while (!highResolutionImage.isLoad()) {
            try {
                System.out.println("Temporary image-- " + highResolutionImage.getWidth() + ": " + highResolutionImage.getHeight());
                // 避免一直询问状态造成系统资源占用过高
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        highResolutionImage.showImage();
    }
}
