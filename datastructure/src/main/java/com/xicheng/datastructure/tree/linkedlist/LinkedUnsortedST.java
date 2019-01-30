package com.xicheng.datastructure.tree.linkedlist;

import com.xicheng.datastructure.tree.symboltable.UnsortedST;

/**
 * @author xichengxml
 * @date 2019/1/30 14:41
 */
public class LinkedUnsortedST<K, V> implements UnsortedST<K, V> {

    /**
     * 链表头结点
     */
    private Node first;

    private class Node {
        K key;
        V value;
        Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public int size() {
        int size = 0;
        Node current = first;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    @Override
    public void put(K key, V value) {
        Node current = first;
        // 如果key值在链表中已存在，更新value值
        while (current != null) {
            if (key.equals(current.key)) {
                current.value = value;
            }
            current = current.next;
        }
        // 如果key值在链表中不存在，使用头插法插入结点
        first = new Node(key, value, first);
    }

    @Override
    public V get(K key) {
        Node current = first;
        while (current != null) {
            if (key.equals(current.key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * 这是单链，不能通过current获取pre值
     * @param key
     */
    @Override
    public void delete(K key) {
        // 空链表
        if (first == null) {
            return;
        }
        // 删除的元素是链表头
        if (key.equals(first.key)) {
            first = first.next;
        }
        Node pre = first;
        Node current = first.next;
        while (current != null) {
            if (key.equals(current.key)) {
                pre.next = current.next;
                return;
            }
            pre = pre.next;
            current = current.next;
        }
    }
}
