package com.xicheng.datastructure.tree.binarytree;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author xichengxml
 * @date 2019/1/31 14:20
 * 添加五个数据，考虑有时候要在中间插入数据，因此不使用连续数据
 * 预计数据添加效果
 *              (6, "test06")
 *               /          \
 *    (2, "test02")         (10, "test10")
 *               \           /
 *           (4, "test04")  (8, "test08")
 */
public class BSTTest {

    private BST<Integer, String> bst = new BST<>();

    @Before
    public void before() {
        bst.put(6, "test06");
        bst.put(2, "test02");
        bst.put(4, "test04");
        bst.put(10, "test10");
        bst.put(8, "test08");
        // 查看一下添加完的数据结构
        // System.out.println(bst.getRoot());
    }

    @Test
    public void sizeTest() {
        assert(5 == bst.size());
    }

    @Test
    public void getTest() {
        assert("test04".equals(bst.get(4)));
    }

    @Test
    public void minTest() {
        assert(2 == bst.min());
    }

    @Test
    public void maxTest() {
        assert(10 == bst.max());
    }

    @Test
    public void rankTest() {
        System.out.println(bst.rank(4));
        System.out.println(bst.rank(10));
    }

    @Test
    public void keysTest() {
        List<Integer> keys = bst.keys(4, 10);
        Stream.of(keys).forEach(System.out::println);
    }

    @Test
    public void floorTest() {
        System.out.println(bst.floor(7));
    }

    @Test
    public void deleteMinTest() {
        bst.deleteMin();
        List<Integer> keys = bst.keys(1, 11);
        Stream.of(keys).forEach(System.out::println);
    }

    @Test
    public void deleteTest() {
        bst.delete(6);
        List<Integer> keys = bst.keys(1, 11);
        Stream.of(keys).forEach(System.out::println);
    }
}
