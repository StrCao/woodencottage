package com.xicheng.concurrent.forkjoinpool;

import org.junit.Test;

/**
 * @author xichengxml
 * @date 2019/2/12 10:14
 */
public class FibonacciTest {

    @Test
    public void test01() {
        // 临界值左
        Fibonacci fibonacci = new Fibonacci(1);
        Integer result = fibonacci.compute();
        assert 1 == result;
        // 临界值
        fibonacci = new Fibonacci(2);
        result = fibonacci.compute();
        assert 1 == result;
        // 临界值右
        fibonacci = new Fibonacci(5);
        result = fibonacci.compute();
        assert 5 == result;
    }
}
