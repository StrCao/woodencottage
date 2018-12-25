package com.xicheng.algorithm.leetcode.removeduplicatesfromsortedlist;

/**
 * @author xichengxml
 * @date 2018/12/25
 * @description
 */
public class RemoveTest03 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return tmp;
    }

    public static void main(String[] args) {

    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
