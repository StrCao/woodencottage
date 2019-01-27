package com.xicheng.bigdata.hadoop.hdfs;



import org.junit.Test;

import java.io.InputStream;
import java.net.URL;

/**
 * @author xichengxml
 * 测试HDFS连接，需要搭建伪分布式hadoop集群
 */
public class HdfsConnectionController {

    @Test
    public void test02() throws Exception {
        /*// 设置支持hdfs协议
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
        // 将某个文件作为输入流
        InputStream inputStream = new URL("hdfs://192.168.133.121:9000/file0126/hello.txt").openStream();
        // 将文件内容输出到控制台
        IOUtils.copyBytes(inputStream, System.out, 4096, true);*/
    }
}
