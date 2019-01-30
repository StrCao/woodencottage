package com.xicheng.datastructure.tree.linkedlist;

import com.xicheng.datastructure.tree.symboltable.SortedST;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xichengxml
 * @date 2019/1/30 15:21
 */
public class BinarySearchOrderedST<K extends Comparable<K>, V> implements SortedST<K, V> {

    private K[] keys;
    private V[] values;
    private int N = 0;

    public BinarySearchOrderedST(int capacity) {
        keys = (K[]) new Comparable[capacity];
        values = (V[]) new Object[capacity];
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void put(K key, V value) {
        int index = rank(key);
        // 如果key值已存在，更新key值
        if (key.equals(keys[index])) {
            values[index] = value;
        } else {
            // 否则在数组中的index位置插入该节点, 需要将index后的数据
            for (int i = N; i > index; i--) {
                keys[i] = keys[i - 1];
                values[i] = values[i - 1];
            }
            keys[index] = key;
            values[index] = value;
            N++;
        }
    }

    @Override
    public V get(K key) {
        int index = rank(key);
        // 如果存在
        if (key.equals(keys[index])) {
            return values[index];
        }
        return null;
    }

    @Override
    public K min() {
        return keys[0];
    }

    @Override
    public K max() {
        return keys[N - 1];
    }

    /**
     * 如果key已存在，返回key的索引位置；否则返回key应该插入的位置
     * 不是很清楚这个方法存在的意义
     * @param key
     * @return
     */
    @Override
    public int rank(K key) {
        int low = 0, high = N - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            int compare = key.compareTo(keys[middle]);
            if (compare > 0) {
                low = middle + 1;
            } else if (compare == 0) {
                return middle;
            } else {
                high = middle - 1;
            }
        }
        return low;
    }

    /**
     * 获取在key值范围low和high之间的所有key
     * @param low
     * @param high
     * @return
     */
    @Override
    public List<K> keys(K low, K high) {
        int index = rank(low);
        List<K> keyList = new ArrayList<>();
        // 因为有序，所以不用考虑index越界 keys[index].compareTo(high)<=0 <=> index<=high
        while (keys[index].compareTo(high) <= 0) {
            keyList.add(keys[index]);
            index++;
        }
        return keyList;
    }
}
