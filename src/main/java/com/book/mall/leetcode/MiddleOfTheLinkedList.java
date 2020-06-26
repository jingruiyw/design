package com.book.mall.leetcode;

import com.book.mall.leetcode.bean.ListNode;

/**
 * ClassName: MiddleOfTheLinkedList
 * Description:
 * 876. 链表的中间结点
 * date: 2020/6/27 2:33 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class MiddleOfTheLinkedList {

    /**
     * 3.双指针：快慢指针：快的每次走两个，慢的每次走一个
     * time:O(n)
     * space:O(1)
     *
     * @param head
     * @return
     */
    public ListNode middleNodeV3(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /**
     * 2.单指针法：第一遍遍历算出链表长度，第二遍遍历取中间值
     * time:O(n)
     * space:O(1)
     *
     * @param head
     * @return
     */
    public ListNode middleNodeV2(ListNode head) {
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        int mid = 0;
        curr = head;
        while (curr != null) {
            if (mid == size / 2) {
                return curr;
            }
            mid++;
            curr = curr.next;
        }

        return null;
    }


    /**
     * 1.数组法
     * time:O(n)
     * space:O(n)
     *
     * @param head
     * @return
     */
    public ListNode middleNodeV1(ListNode head) {
        ListNode[] array = new ListNode[100];
        int sum = 0;
        while (head != null) {
            array[sum++] = head;
            head = head.next;
        }
        return array[sum / 2];
    }
}
