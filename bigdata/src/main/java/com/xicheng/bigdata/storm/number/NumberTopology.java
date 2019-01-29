package com.xicheng.bigdata.storm.number;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.generated.StormTopology;
import backtype.storm.topology.TopologyBuilder;

/**
 * @author xichengxml
 * @date 2019/1/29 20:04
 * Spout产生100以内的随机数，然后在Dispatcher中判断，大于50的发送到moreThan通道；否则发到lessThan通道。
 * MoreThanBolt和LessThanBolt从对应通道取出并打印数字
 */
public class NumberTopology {

    public static void main(String[] args) {
        Config config = new Config();
        NumberSpout numberSpout = new NumberSpout();
        DispatcherBolt dispatcherBolt = new DispatcherBolt();
        MoreThanBolt moreThanBolt = new MoreThanBolt();
        LessThanBolt lessThanBolt = new LessThanBolt();

        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("numberSpout", numberSpout);
        builder.setBolt("dispatcherBolt", dispatcherBolt)
                .globalGrouping("numberSpout");
        builder.setBolt("moreThanBolt", moreThanBolt)
                .globalGrouping("dispatcherBolt", "moreThan");
        builder.setBolt("lessThanBolt", lessThanBolt)
                .globalGrouping("dispatcherBolt", "lessThan");
        StormTopology topology = builder.createTopology();

        LocalCluster localCluster = new LocalCluster();
        localCluster.submitTopology("numberTopology", config, topology);

    }
}
