package com.xicheng.flink.file;

import com.google.gson.Gson;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author xichengxml
 * @date 2019/3/5 13:29
 * 从文件中读取数据进行处理
 */
public class FileWordCount {

    private static final Gson GSON = new Gson();

    public static void main(String[] args) {
        // 创建入口类
        StreamExecutionEnvironment environment = StreamExecutionEnvironment.createLocalEnvironment();
        DataStreamSource<String> dataStream = environment.readTextFile("file:///file/hello.txt");
        System.out.println(GSON.toJson(dataStream));
    }
}
