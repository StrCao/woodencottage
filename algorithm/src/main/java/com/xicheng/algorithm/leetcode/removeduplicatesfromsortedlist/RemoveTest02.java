package com.xicheng.algorithm.leetcode.removeduplicatesfromsortedlist;

/**
 * @author xichengxml
 * @date 2018/12/25
 * @description 输入111会报错
 */
public class RemoveTest02 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return tmp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        ListNode listNode = deleteDuplicates(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
