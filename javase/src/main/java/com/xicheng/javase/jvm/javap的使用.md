##### javap的使用
1. 创建类
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.print("Hello World");
    }
}
```
2. 使用javac编译
```swagger codegen
PS C:\Users\liubin52\Desktop> javac .\HelloWorld.java
```
3. 使用javap -c 查看类信息
```swagger codegen
PS C:\Users\liubin52\Desktop> javap -c .\HelloWorld.class
Compiled from "HelloWorld.java"
public class HelloWorld {
  public HelloWorld();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #3                  // String Hello World
       5: invokevirtual #4                  // Method java/io/PrintStream.print:(Ljava/lang/String;)V
       8: return
}
```