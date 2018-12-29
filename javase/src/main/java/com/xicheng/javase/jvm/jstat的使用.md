1. 新建测试类
```java
package com.xicheng.javase.jvm;

import org.junit.Test;

/**
 * @author xichengxml
 * @date 2018/12/29
 * @description
 */
public class JvmTest01 {

    @Test
    public void test01() throws Exception{
        System.out.println("hi jstat");
        System.in.read(); // 保证执行命令时程序仍在执行
    }
}

```
2. 使用jps查看进程
```swagger codegen
C:\Users\liubin52>jps
24704 Launcher
15876 JUnitStarter
23236 Jps
22840 RemoteMavenServer
7996
```
3. 使用jstat查看类加载等信息
```swagger codegen
C:\Users\liubin52>jstat -class 15876
Loaded  Bytes  Unloaded  Bytes     Time
   933  1750.0        0     0.0       0.21
```

具体用法参考文章：http://www.importnew.com/23761.html