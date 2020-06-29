package com.book.mall.leetcode.linkedlist;

import com.book.mall.leetcode.bean.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: PalindromeLinkedList
 * Description:
 * 234.回文链表
 * date: 2020/6/29 11:15 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(-129);
        node.next = new ListNode(-129);
        System.out.println(isPalindromeV1(node));
    }

    /**
     * 2.更改链表后半段
     * 步骤：
     * 1. 找到前半部分的尾节点
     * 2. 翻转后半部分链表
     * 3. 判断是否为回文
     * 4. 恢复链表
     * 5. 返回结果
     *
     * time:O(n)
     * space:O(1)
     *
     * @param head
     * @return
     */
    private static boolean isPalindromeV2(ListNode head) {
        //判空
        if (head == null) {
            return true;
        }
        //获取前半部分尾结点并翻转后半部分链表
        ListNode firstHalf = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalf.next);

        //检查是否是回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        //恢复链表:再翻转一次
        firstHalf.next = reverseList(secondHalfStart);
        return result;
    }

    /**
     * 翻转后半个链表
     *
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        return prev;
    }

    /**
     * 快慢指针找到前半部分尾节点
     *
     * @param head
     * @return
     */
    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * 1.把链表里的值转到数组里，再用双指针判断数组是否为回文数组
     * time:O(n)
     * space:O(n)
     *
     * @param head
     * @return
     */
    private static boolean isPalindromeV1(ListNode head) {
        List<Integer> nodeVal = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            nodeVal.add(curr.val);
            curr = curr.next;
        }
        int start = 0;
        int end = nodeVal.size() - 1;
        while (start <= end) {
            if (!nodeVal.get(start).equals(nodeVal.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
