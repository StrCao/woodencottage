package com.xicheng.stream.nio.channel;

import org.junit.Test;

import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author xichengxml
 * @date 2018/12/24
 * @description
 */
public class FileChannelController {

    @Test
    public void test01() throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\user\\github\\woodencottage\\stream\\src\\main\\resources\\FileChannel.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int read = channel.read(buffer);
        while (read != -1) {
            System.out.println("read:" + (char)read);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println("buffer:" + (char)buffer.get());
            }
            buffer.clear();
            read = channel.read(buffer);
        }
        randomAccessFile.close();
    }

    public void test02() throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\user\\github\\woodencottage\\stream\\src\\main\\resources\\ScatterGather.txt", "rw");
        ByteBuffer head = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);
        ByteBuffer[] buffers = {head, body};
        FileChannel fileChannel = randomAccessFile.getChannel();
        fileChannel.read(buffers);
    }
}
