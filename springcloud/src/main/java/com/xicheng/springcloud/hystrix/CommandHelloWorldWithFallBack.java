package com.xicheng.springcloud.hystrix;

import com.netflix.hystrix.HystrixCommand;

import java.util.Arrays;
import java.util.List;

/**
 * @author xichengxml
 * @date 2019/1/11 9:57
 */
public class CommandHelloWorldWithFallBack extends HystrixCommand<String> {

    private static final List<Integer> timeList = Arrays.asList(100, 200, 300, 400, 500, 600,
            700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000, 2100);
    private String name;
    private int timeIndex;

    public CommandHelloWorldWithFallBack(Setter setter, String name, int timeIndex) {
        super(setter);
        this.name = name;
        this.timeIndex = timeIndex;
    }

    @Override
    protected String getFallback() {
        return "Fall back time in milliSeconds:" + timeList.get(timeIndex);
    }

    @Override
    protected String run() throws Exception {
        Thread.sleep(timeList.get(timeIndex));
        return "Run time in milliSeconds:" + timeList.get(timeIndex);
    }

    public int getTimeIndex() {
        return timeIndex;
    }

    public void setTimeIndex(int timeIndex) {
        this.timeIndex = timeIndex;
    }
}
