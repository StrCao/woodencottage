package com.xicheng.validator;

/**
 * @author xichengxml
 * @date 2019/3/7 16:45
 */
public class Main {

    public static void main(String[] args) {
        Son son = new Son();
        son.mfather = new Son();
        magicCode(son, false);
        son.mfather = new Father();
        magicCode(son, false);
    }

    /**
     * 对这段魔性代码做个解释，进行了两个赋值操作，这个需要了解for循环的执行机制：
     * 第一个语句是赋值语句；第二个语句是判断语句，如果为true则一直执行，直到为false退出；
     * 第三个语句是赋值语句
     *
     * 所以上述的解释为：首先对flag赋值，然后判断father的类型，一直循环到不是son类型，把值
     * 赋给father
     * @param father
     * @param flag
     */
    private static void magicCode(Father father, boolean flag) {
        int count = 0;
        for (flag = true; father instanceof Son; father = ((Son) father).mfather) {
            count++;
        }
        System.out.println("loop times:" + count);
        System.out.println(flag);
        if (father == null) {
            System.out.println("null");
        } else {
            System.out.println(father.getClass());
        }
    }

    static class Father {

    }

    static class Son extends Father {
        Father mfather;
    }
}
