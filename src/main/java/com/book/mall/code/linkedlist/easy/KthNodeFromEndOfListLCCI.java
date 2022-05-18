package com.book.mall.code.linkedlist.easy;

import com.book.mall.code.linkedlist.ListNode;

/**
 * ClassName: KthNodeFromEndOfListLCCI
 * Description:返回倒数第 k 个节点
 * <p>
 * 示例：
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 * 给定的 k 保证是有效的。
 * <p>
 * date: 2020/12/9 2:32 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class KthNodeFromEndOfListLCCI {

    public static void main(String[] args) {
        ListNode m = new ListNode(1);
        m.next = new ListNode(2);
        m.next.next = new ListNode(3);
        m.next.next.next = new ListNode(4);
        m.next.next.next.next = new ListNode(5);
        System.out.println(kthToLast(m, 2));
    }

    //双指针
    public static int kthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;

        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

    public static ListNode kthToLast2(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (k > 0) {
            // 快节点先走一段距离
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            // 快慢一起移动
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
