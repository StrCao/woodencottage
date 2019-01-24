package com.xicheng.springcloud.rpc;

import java.io.Serializable;

/**
 * @author xichengxml
 * @date 2019/1/24 17:46
 */
public interface HelloService extends Serializable {

    String sayHello(String name);
}
