package com.xicheng.flink.myflink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

public class SocketWindowWordCount {

    public static void main(String[] args) throws Exception {
        // 创建入口类
        StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();
        // 创建一个从本地端口9000的socket中读取数据的数据源
        DataStreamSource<String> text = environment.socketTextStream("localhost", 9000, "\n");
        // 解析数据，按word分组，开窗，聚合
        SingleOutputStreamOperator<Tuple2<String, Integer>> wordCounts = text.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public void flatMap(String input, Collector<Tuple2<String, Integer>> out) throws Exception {
                String[] words = input.split("\\s");
                for (String word : words) {
                    out.collect(Tuple2.of(word, 1));
                }
            }
        });

        SingleOutputStreamOperator<Tuple2<String, Integer>> windowCounts = wordCounts.keyBy(0)
                .timeWindow(Time.seconds(5))
                .sum(1);

        // 将结果打印到控制台，注意这里是单线程打印，而非多线程
        windowCounts.print().setParallelism(1);
        environment.execute("Socket Window WordCount");

    }
}
