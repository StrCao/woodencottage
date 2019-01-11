package com.xicheng.springcloud.hystrix;

import com.netflix.hystrix.HystrixCommand;

/**
 * @author xichengxml
 * @date 2019/1/11 14:04
 */

public class CommandHelloWorldWithFallBack02 extends HystrixCommand<String> {

    public CommandHelloWorldWithFallBack02(Setter setter) {
        super(setter);
    }

    @Override
    protected String run() throws Exception {
        return null;
    }
}
