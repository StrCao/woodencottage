package com.xicheng.newfeature.controller;

import com.xicheng.newfeature.util.PrintUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author xichengxml
 * @date 2019/1/2 13:55
 */
public class ParallelStreamController {

    private static final int MAX = 1000000;
    private static List<String> stringList = new ArrayList<>(MAX);
    private static long count = 0;
    @Before
    public void before() {
        for (int i = 0; i < MAX; i++) {
            UUID uuid = UUID.randomUUID();
            stringList.add(uuid.toString());
        }
    }

    @Test
    public void test01() {
        long start = System.nanoTime();
        // 串行排序
        count = stringList.stream().sorted().count();
        long middle = System.nanoTime();
        PrintUtil.print(count, middle - start);
        count = stringList.parallelStream().sorted().count();
        long end = System.nanoTime();
        PrintUtil.print(count, end - middle);
    }
}
