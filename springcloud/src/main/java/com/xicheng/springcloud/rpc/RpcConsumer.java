package com.xicheng.springcloud.rpc;

/**
 * @author xichengxml
 * @date 2019/1/24 17:50
 */
public class RpcConsumer {

    public static void main(String[] args) throws Exception {
        HelloService helloService = RpcFramework.consume(HelloService.class, "127.0.0.1", 10086);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String name = "Sun Wukong" + i;
            String result = helloService.sayHello(name);
            System.out.println(result);
            Thread.sleep(1000);
        }
    }
}
