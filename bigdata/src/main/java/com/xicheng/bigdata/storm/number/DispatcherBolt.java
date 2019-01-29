package com.xicheng.bigdata.storm.number;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

import java.util.Map;

/**
 * @author xichengxml
 * @date 2019/1/29 19:58
 */
public class DispatcherBolt extends BaseRichBolt {

    private OutputCollector outputCollector;
    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.outputCollector = outputCollector;
    }

    @Override
    public void execute(Tuple tuple) {
        int number = tuple.getIntegerByField("number");
        if (number < 50) {
            outputCollector.emit("lessThan", new Values(number));
        } else {
            outputCollector.emit("moreThan", new Values(number));
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declareStream("lessThan", new Fields("number"));
        outputFieldsDeclarer.declareStream("moreThan", new Fields("number"));
    }
}
