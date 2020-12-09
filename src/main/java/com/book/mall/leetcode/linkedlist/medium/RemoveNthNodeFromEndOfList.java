package com.book.mall.leetcode.linkedlist.medium;

import com.book.mall.leetcode.bean.ListNode;

/**
 * ClassName: RemoveNthNodeFromEndOfList
 * Description:
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第n个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * date: 2020/12/9 4:24 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class RemoveNthNodeFromEndOfList {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEnd(head, 1));
    }

    //快慢指针，使用dummy节点使其next节点指向head
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        while (n > 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
