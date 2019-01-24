package com.xicheng.javase.reflection;

/**
 * @author xichengxml
 * @date 2019/1/24 10:13
 */
public class HelloServiceImpl implements HelloService {

    private static final String FORMAT_PRE = "Hello, %s";

    @Override
    public String sayHello(String name) {
        return String.format(FORMAT_PRE, name);
    }
}
