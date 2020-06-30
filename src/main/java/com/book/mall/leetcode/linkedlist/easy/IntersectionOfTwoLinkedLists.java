package com.book.mall.leetcode.linkedlist.easy;

import com.book.mall.leetcode.bean.ListNode;

/**
 * ClassName: IntersectionOfTwoLinkedLists
 * Description:
 * 160. 相交链表
 * date: 2020/6/18 12:12 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class IntersectionOfTwoLinkedLists {


    /**
     * 1.双指针：利用差值
     * time:O(n)
     * space:O(1)
     * <p>
     * 2.暴力法：双循环 time: O(n^2) space: O(1)
     * 3.哈希表法：把链表A的每个引用存在哈希表中，检查B表每个节点是否在哈希表中存在 time:O(n) space:O(n)
     *
     * @param headA
     * @param headB
     * @return
     */
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        //a+b = b+a 无交叉两个最终指向null 跳出循环
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        //当a/b相等时，相等的指针指向的即为相交点
        return a;
    }
}
