package com.xicheng.bigdata.storm.wordcount;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

public class WordCountTopology {

    public static void main(String[] args) {
        Config config = new Config();
        // 设置并发数
        config.setNumWorkers(2);
        config.setDebug(true);

        // 创建各种数据流对象
        WordCountSpout wordCountSpout = new WordCountSpout();
        SplitBolt splitBolt = new SplitBolt();
        WordCountBolt wordCountBolt = new WordCountBolt();
        PrintBolt printBolt = new PrintBolt();

        // 创建拓扑
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("wordCountSpout", wordCountSpout);
        builder.setBolt("splitBolt", splitBolt)
                // 随机数据流分组
                .shuffleGrouping("wordCountSpout");
        builder.setBolt("wordCountBolt", wordCountBolt)
                // 相同字段落到同一个bolt里
                .fieldsGrouping("splitBolt", new Fields("splitData"));
        builder.setBolt("printBolt", printBolt)
                // 数据汇总到一个bolt上
                .globalGrouping("wordCountBolt");
        StormTopology topology = builder.createTopology();

        // 本地集群模式
        LocalCluster localCluster = new LocalCluster();
        localCluster.submitTopology("wordCountTopology", config, topology);

    }
}
