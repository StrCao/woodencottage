package com.xicheng.concurrent.forkjoinpool;

import java.util.concurrent.RecursiveTask;

/**
 * @author xichengxml
 * @date 2019/2/12 10:06
 * 斐波那契数列数列从第3项开始,每一项都等于前两项之和。 例子:数列 1, 1, 2, 3, 5, 8, 13, 21, 34
 * 分而治之伪代码：
 * Result solve(Problem problem) {
 *  if (problem is small) {
 *      directly solve problem
 *  } else {
 *      split problem into independent parts
 *      fork new subtasks to solve each part
 *      join all subtasks
 *      compose result from subresults
 *  }
 * }
 */
public class Fibonacci extends RecursiveTask<Integer> {

    private int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        } else {
            Fibonacci f1 = new Fibonacci(n - 1);
            f1.fork();
            Fibonacci f2 = new Fibonacci(n - 2);
            return f1.join() + f2.compute();
        }
    }
}
