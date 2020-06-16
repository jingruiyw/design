package com.book.mall.leetcode.doublePoint;

import com.book.mall.leetcode.bean.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: LinkedListCycle
 * Description: 环形链表
 * 判断一个链表是否有环
 * date: 2020/6/17 12:48 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class LinkedListCycle {

    /**
     * 2.快慢指针: 有环则快指针会追上慢指针，两指针相等；无环则最终两指针都为null
     * time：O(n)
     * space:O{1}
     *
     * @param head
     * @return
     */
    public boolean hasCycleV2(ListNode head) {

        if (head == null || head.next == null) {
            //无节点或者只有一个节点不成环
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        //不相等循环
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            //慢指针增加一个
            slow = slow.next;
            //快指针增加两个
            fast = fast.next.next;
        }
        //有环两个最终会相等
        return true;
    }

    /**
     * 1.hashSet 方法
     * time:O(n)
     * space:O(n)
     *
     * @param head
     * @return
     */
    public boolean hasCycleV1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                //包含则说明有环
                return true;
            } else {
                //不包含则把遍历过的head放进集合
                set.add(head);
            }
            head = head.next;
        }
        //到最后都没有则表示无环
        return false;
    }
}
