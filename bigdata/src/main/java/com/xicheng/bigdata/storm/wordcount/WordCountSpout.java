package com.xicheng.bigdata.storm.wordcount;



import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

import java.util.Map;

public class WordCountSpout extends BaseRichSpout {

    private SpoutOutputCollector spoutOutputCollector;
    private static final String[] SOURCE_DATA = new String[]{"hello bigdata", "hello storm", "hello spout"};
    private int index = 0;
    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.spoutOutputCollector = spoutOutputCollector;
    }

    @Override
    public void nextTuple() {
        String sourceDatum = SOURCE_DATA[index++];
        spoutOutputCollector.emit(new Values(sourceDatum));
        // 循环产生数据源的数据
        if (index == SOURCE_DATA.length) {
            index = 0;
        }
        // 延时处理，避免数据产生过快
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("srcData"));
    }
}
