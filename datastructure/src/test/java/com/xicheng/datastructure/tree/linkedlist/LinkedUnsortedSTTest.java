package com.xicheng.datastructure.tree.linkedlist;

import org.junit.Before;
import org.junit.Test;

/**
 * @author xichengxml
 * @date 2019/1/30 17:19
 * 测试思路：添加5组随机数据
 */
public class LinkedUnsortedSTTest {

    private LinkedUnsortedST<Integer, String> linkedUnsortedST = new LinkedUnsortedST<>();

    @Before
    public void before() {
        linkedUnsortedST.put(2, "test02");
        linkedUnsortedST.put(8, "test08");
        linkedUnsortedST.put(10, "test10");
        linkedUnsortedST.put(6, "test06");
        linkedUnsortedST.put(4, "test04");
    }

    @Test
    public void deleteTest() {
        linkedUnsortedST.delete(8);
        System.out.println(linkedUnsortedST.get(8));
        System.out.println(linkedUnsortedST.size());
    }

    @Test
    public void sizeTest() {
        System.out.println(linkedUnsortedST.size());
    }

    @Test
    public void getTest() {
        System.out.println(linkedUnsortedST.get(6));
    }
}
