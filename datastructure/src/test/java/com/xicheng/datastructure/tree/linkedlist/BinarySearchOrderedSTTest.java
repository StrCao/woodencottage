package com.xicheng.datastructure.tree.linkedlist;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author xichengxml
 * @date 2019/1/30 16:37
 * 测试case：在BinarySearchOrderedST中随机插入5组数据，获取数据的各种操作结果进行对比
 */
public class BinarySearchOrderedSTTest {

    private  BinarySearchOrderedST<Integer, String> binarySearchOrderedST = new BinarySearchOrderedST<>(10);

    /**
     * 打乱顺序插入5个数据，考虑到数据插入，采用1~5的数字乘以2
     */
    @Before
    public void before() {
        binarySearchOrderedST.put(2, "test02");
        binarySearchOrderedST.put(6, "test06");
        binarySearchOrderedST.put(10, "test10");
        binarySearchOrderedST.put(8, "test08");
        binarySearchOrderedST.put(4, "test04");
    }

    @Test
    public void sizeTest() {
        assert 5 == binarySearchOrderedST.size();
    }

    @Test
    public void getTest() {
        assert "test02".equals(binarySearchOrderedST.get(2));
        assert null == binarySearchOrderedST.get(11);
    }

    /**
     * 获取所有key值，打印
     */
    @Test
    public void keysTest() {
        int low = 0;
        int high = 10;
        List<Integer> keyList = binarySearchOrderedST.keys(low, high);
        Stream.of(keyList).forEach(System.out::println);
    }

    @Test
    public void rankTest() {
        int key01 = 1;
        int key02 = 7;
        int key03 = 11;
        System.out.println(binarySearchOrderedST.rank(key01));
        System.out.println(binarySearchOrderedST.rank(key02));
        System.out.println(binarySearchOrderedST.rank(key03));
    }
}
