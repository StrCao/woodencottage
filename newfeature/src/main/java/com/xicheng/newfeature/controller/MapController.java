package com.xicheng.newfeature.controller;

import com.xicheng.newfeature.util.PrintUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xichengxml
 * @date 2019/1/2 14:26
 */
public class MapController {
    private static Map<Integer, String> map = new HashMap<>();

    @Before
    public void before() {
        for (int i = 0; i < 100; i++) {
            map.putIfAbsent(i, "val" + i);
        }
    }

    @Test
    public void test01() {
        map.forEach((key, val) -> PrintUtil.print(key, val));
    }
}
