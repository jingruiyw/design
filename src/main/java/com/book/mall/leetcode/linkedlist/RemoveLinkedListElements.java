package com.book.mall.leetcode.linkedlist;

import com.book.mall.leetcode.bean.ListNode;

/**
 * ClassName: RemoveLinkedListElements
 * Description:
 * 203. 移除链表元素
 * 移除链表中与给给定值相同的元素，链表元素可重复，被删除元素可能为头为尾
 * date: 2020/6/26 1:04 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class RemoveLinkedListElements {

    private static ListNode removeElements(ListNode head, int val) {
        //虚拟哨兵节点
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel;
        ListNode curr = sentinel.next;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            //把当前节点向后移动
            curr = curr.next;
        }

        //返回哨兵节点的下一位，可应对头结点被删除的情况
        return sentinel.next;
    }
}
