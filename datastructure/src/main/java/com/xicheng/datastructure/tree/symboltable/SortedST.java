package com.xicheng.datastructure.tree.symboltable;

import java.util.List;

/**
 * @author xichengxml
 * @date 2019/1/30 14:31
 */
public interface SortedST<K extends Comparable<K>, V>{

    int size();

    void put(K key, V value);

    V get(K key);

    K min();

    K max();

    int rank(K key);

    List<K> keys(K low, K high);
}
