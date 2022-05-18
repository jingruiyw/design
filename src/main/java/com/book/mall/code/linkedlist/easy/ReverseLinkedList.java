package com.book.mall.code.linkedlist.easy;

import com.book.mall.code.linkedlist.ListNode;

/**
 * ClassName: ReverseLinkedList
 * Description: 翻转单链表
 * 206. Reverse Linked List
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * <p>
 * date: 2020/5/27 2:13 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        System.out.println(reverseList(head));
//        System.out.println(reversListRecursive(head));
        System.out.println(reverseList3(head));
    }

    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode reverseList1(ListNode head) {
        //不为空或者只有一个节点不需要翻转
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    /**
     * 1、交换前后节点
     * <p>
     * time : O(n)
     * space : O(1)
     *
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        //前面是转换好的
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            //更新prex
            prev = curr;
            //更新curr
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 2、递归遍历
     * <p>
     * time：O(n)
     * space：O(n)
     *
     * @param head
     * @return
     */
    private static ListNode reversListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //五个数字，head等于4的时候就返回了
        ListNode curr = reversListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return curr;
    }
}


