package com.xicheng.springcloud.rpc;

/**
 * @author xichengxml
 * @date 2019/1/24 17:47
 */
public class HelloServiceImpl implements HelloService {

    private static final String INFO_PRE = "Hello, %s";
    @Override
    public String sayHello(String name) {
        return String.format(INFO_PRE, name);
    }
}
