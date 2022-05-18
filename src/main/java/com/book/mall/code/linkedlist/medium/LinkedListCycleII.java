package com.book.mall.code.linkedlist.medium;

import com.book.mall.code.linkedlist.ListNode;

/**
 * ClassName: LinkedListCycleII
 * Description:
 * 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * date: 2021/4/16 12:14 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class LinkedListCycleII {

    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        // 注意判 fast 为空
        while (fast != null && fast.next != null) {
            slow = slow.next;
            // 注意fast是走两个
            fast = fast.next.next;
            if (fast == slow) {
                // 有环，slow继续走，声明一个指针从头走，相遇就是入环点
                ListNode res = head;
                while (res != slow) {
                    res = res.next;
                    // 注意slow也要走
                    slow = slow.next;
                }
                return res;
            }
        }
        return null;
}

    /**
     * time: o(n * c)
     * a: head到入环点距离
     * b: 入环点到相遇距离
     * c: 相遇再到入环点距离
     * 关键：数学推理：a=c
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                //声明新指针找入环点
                ListNode p = head;
                while (p != s) {
                    p = p.next;
                    //s也得走！！！
                    s = s.next;
                }
                return p;
            }
        }
        return null;
    }
}
