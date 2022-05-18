package com.book.mall.code.linkedlist.easy;

import com.book.mall.code.linkedlist.ListNode;

/**
 * ClassName: MergeTwoSortedLists
 * Description:
 * 21. 合并两个有序链表
 * date: 2020/6/23 12:40 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class MergeTwoSortedLists {

    private static ListNode mergeTwoListsV3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode prevHead = new ListNode(-1);
        ListNode prev = prevHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        //全循环完毕后，剩下的把 prev next 直接指过去即可；
        prev.next = l1 == null ? l2 : l1;
        return prevHead.next;
    }

    /**
     * 2.递归思想：第一个小的节点的next指向和整体结构相同，可用递归
     * time:O(n+m)
     * space:O(m+n)
     *
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoListsV2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsV2(l2.next, l1);
            return l2;
        }
    }

    /**
     * 1.暴力法
     * time:O(m+n)
     * space:(1)
     *
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode mergeTwoListsV1(ListNode l1, ListNode l2) {
        ListNode prevHead = new ListNode(-1);
        ListNode prev = prevHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return prevHead.next;
    }
}
