package com.xicheng.springcloud.hystrix;

import com.netflix.hystrix.*;

/**
 * @author xichengxml
 * @date 2019/1/11 10:06
 */
public class HelloWorldFallBack {

    public static void main(String[] args) {
        int count = 0;
        for (;;) {
            String s = new CommandHelloWorldWithFallBack(HystrixCommand.Setter
                    .withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                    .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("threadPoolWithFallback"))
                    .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                            .withCoreSize(10)
                            .withMaximumSize(10))
                    .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                            .withExecutionTimeoutInMilliseconds(1000)
                            .withCircuitBreakerSleepWindowInMilliseconds(5000)
                            .withCircuitBreakerErrorThresholdPercentage(50)
                            .withCircuitBreakerRequestVolumeThreshold(1))
                    , "ccc", count % 20).execute();
            System.out.println(s);
            count++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
