package com.xicheng.datastructure.tree.binarytree;

import com.xicheng.datastructure.tree.symboltable.SortedST;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xichengxml
 * @date 2019/1/31 10:24
 * 所有对外暴露的方法都是从根节点开始，底层具体实现使用private方法
 */
public class BST<K extends Comparable<K>, V> implements SortedST<K, V> {

    private Node root;

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        // 以该节点为根的子节点总数
        int N;
        // 红黑树中使用
        boolean color;

        public Node(K key, V value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    ", N=" + N +
                    ", color=" + color +
                    '}';
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * 从根节点开始计数
     * @return
     */
    @Override
    public int size() {
        return size(root);
    }

    /**
     * 统计任意节点的子节点总数（含自身）
     * @param node 任意节点
     * @return
     */
    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    /**
     *
     * @param node 任意节点
     */
    public void recalculateSize(Node node) {
        node.N = size(node.left) + size(node.right) + 1;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    /**
     * 注意：需要考虑递归，找到真正存放元素的位置
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node put(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int compare = key.compareTo(node.key);
        // key值存在且等于当前node的key，更新value
        if (compare == 0) {
            node.value = value;
        } else if (compare < 0) {
            // 小于node值，放到左子树
            node.left = put(node.left, key, value);
        } else {
            // 大于node值，放到右子树
            node.right = put(node.right, key, value);
        }
        recalculateSize(node);
        return node;
    }

    /**
     * 从根节点开始遍历查找
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }
        int compare = key.compareTo(node.key);
        if (compare == 0) {
            return node.value;
        } else if (compare < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    @Override
    public K min() {
        Node min = min(root);
        return min == null ? null : min.key;
    }

    /**
     * 因为最小值一定存在于左子树，所以不用考虑右子树
     * @param node
     * @return
     */
    private Node min(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    @Override
    public K max() {
        Node max = max(root);
        return max == null ? null : max.key;
    }

    /**
     * 最大值一定在右子树，不考虑左子树
     * @param node
     * @return
     */
    private Node max(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node;
        } else {
            return max(node.right);
        }
    }

    /**
     * 返回key的排名, 即索引值
     * @param key
     * @return
     */
    @Override
    public int rank(K key) {
        return rank(root, key);
    }

    /**
     * 这个方法不可设置为public，否则会有漏洞，举例如下
     *          3
     *         / \
     *        2   5
     *       /     \
     *      1       4
     * 如果此时输入6，node选择2，结果为1
     * 一定要从root节点开始遍历
     * @param node
     * @param key
     * @return
     */
    private int rank(Node node, K key) {
        if (node == null) {
            return 0;
        }
        int compare = key.compareTo(node.key);
        if (compare == 0) {
            // 直接计算当前node的子节点数（含自身）
            return size(node.left);
        } else if (compare < 0) {
            // 继续遍历查找左子树
            return rank(node.left, key);
        } else {
            // 根节点 + 左子树 + 右子树排名
            return 1 + size(node.left) + rank(node.right, key);
        }
    }
    @Override
    public List<K> keys(K low, K high) {
        return keys(root, low, high);
    }

    /**
     * 利用中序遍历（暂时未懂）
     * @param node
     * @param low
     * @param high
     * @return
     */
    private List<K> keys(Node node, K low, K high) {
        List<K> keyList = new ArrayList<>();
        if (node == null) {
            return keyList;
        }
        int compareLow = low.compareTo(node.key);
        int compareHigh = high.compareTo(node.key);
        if (compareLow < 0) {
            keyList.addAll(keys(node.left, low, high));
        }
        if (compareHigh >= 0 && compareLow <= 0) {
            keyList.add(node.key);
        }
        if (compareHigh > 0) {
            keyList.addAll(keys(node.right, low, high));
        }
        return keyList;
    }

    /**
     * 小于等于key的最大键
     * @param key
     * @return
     */
    public K floor(K key) {
        Node floor = floor(root, key);
        return floor == null ? null : floor.key;
    }

    private Node floor(Node node, K key) {
        if (node == null) {
            return null;
        }
        int compare = key.compareTo(node.key);
        Node result;
        if (compare == 0) {
            result = node;
        } else if (compare < 0) {
            result = floor(node.left, key);
        } else {
            result = floor(node.right, key);
        }
        return result;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node == null) {
            return null;
        }
        // 考虑没有左子树的情况
        if (node.left == null) {
            return node.right;
        } else {
            node.left = deleteMin(node.left);
        }
        recalculateSize(node);
        return node;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) {
            return null;
        }
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = delete(node.left, key);
        } else if (compare > 0) {
            node.right = delete(node.right, key);
        } else {
            // 删除当前节点，指向非空子树
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            // 不清楚下面这部分代码的作用
            Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        recalculateSize(node);
        return node;
    }
}
