package com.xicheng.datastructure.tree.symboltable;

/**
 * @author xichengxml
 * @date 2019/1/30 14:28
 */
public interface UnsortedST<K, V> {

    int size();

    void put(K key, V value);

    V get(K key);

    void delete(K key);
}
