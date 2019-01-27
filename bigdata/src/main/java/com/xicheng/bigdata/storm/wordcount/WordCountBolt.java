package com.xicheng.bigdata.storm.wordcount;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.HashMap;
import java.util.Map;

public class WordCountBolt extends BaseRichBolt {

    private OutputCollector outputCollector;
    private HashMap<String, Integer> dataMap = new HashMap<>();
    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.outputCollector = outputCollector;
    }

    @Override
    public void execute(Tuple tuple) {
        String splitData = tuple.getStringByField("splitData");
        // 如果已存在，做自增操作；否则添加
        if (dataMap.containsKey(splitData)) {
            dataMap.put(splitData, dataMap.get(splitData) + 1);
        } else {
            dataMap.put(splitData, 1);
        }
        outputCollector.emit(new Values(splitData, dataMap.get(splitData)));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("word", "count"));
    }
}
