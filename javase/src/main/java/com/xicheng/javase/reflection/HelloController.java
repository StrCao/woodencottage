package com.xicheng.javase.reflection;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xichengxml
 * @date 2019/1/24 10:01
 * 程序有问题无法执行，待修复
 */
public class HelloController {

    @Test
    public void test01() throws Exception {
        Class<?> proxyClass = Proxy.getProxyClass(HelloService.class.getClassLoader(), new Class[]{HelloService.class});
        Method method = proxyClass.getMethods()[0];
        System.out.println(method);
        Object lisi = method.invoke(proxyClass, "name");
        System.out.println(lisi);
    }

    @Test
    public void test02() throws Exception {
        Class<?> proxyClass = Proxy.getProxyClass(HelloService.class.getClassLoader(), new Class[]{HelloService.class});
        Method sayHello = proxyClass.getDeclaredMethod("sayHello", String.class);
        System.out.println(sayHello);
        Object hello = sayHello.invoke(proxyClass.newInstance(), "name");
        System.out.println(hello);
    }
}
