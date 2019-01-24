package com.xicheng.springcloud.rpc;

/**
 * @author xichengxml
 * @date 2019/1/24 17:50
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception {
        HelloService helloService = new HelloServiceImpl();
        RpcFramework.provide(helloService, 10086);
    }
}
