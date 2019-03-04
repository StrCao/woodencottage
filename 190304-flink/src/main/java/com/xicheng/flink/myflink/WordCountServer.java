package com.xicheng.flink.myflink;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 生成数据
 */
public class WordCountServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9000);
        Socket server = serverSocket.accept();
        OutputStream outputStream = server.getOutputStream();
        while (true) {
            String s = "hello world, hello flink, good night";
            outputStream.write(s.getBytes());
            Thread.sleep(100);
        }
    }
}
