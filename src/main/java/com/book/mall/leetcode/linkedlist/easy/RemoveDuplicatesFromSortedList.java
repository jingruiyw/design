package com.book.mall.leetcode.linkedlist.easy;

import com.book.mall.leetcode.linkedlist.ListNode;


/**
 * ClassName: RemoveDuplicatesfromSortedList
 * Description:
 * 83. 删除排序链表中的重复元素
 * date: 2020/6/23 9:06 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        System.out.println(listNode);
        System.out.println("--->");
        System.out.println(deleteDuplicates(listNode));
    }

    /**
     * 递归法
     *
     * @param head
     * @return
     */
    private static ListNode deleteDuplicatesV2(ListNode head) {
        if (head == null || head.next == null) {
            //递归结束的条件
            return head;
        }
        head.next = deleteDuplicatesV2(head.next);
        //数值相等，返回head.next
        if (head.val == head.next.val) {
            return head.next;
        }
        //不相等返回head
        return head;
    }


        /**
         * 1.考察对链表的操作:
         * 1) curr.next 与 curr重复，curr不变，删除curr.next,直到不重复
         * 2）curr.next 与 curr不重复，curr向后移动，以此类推
         * 3) 当遍历到最后一次，curr指向链表最后一个节点，curr.next = null，此时无需再遍历，重复项皆已去除
         *
         * time:O(n)
         * space:O(1)
         *
         * @param head
         * @return
         */
    private static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
