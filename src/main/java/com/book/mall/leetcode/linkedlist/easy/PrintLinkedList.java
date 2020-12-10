package com.book.mall.leetcode.linkedlist.easy;

import com.book.mall.leetcode.bean.ListNode;

import java.util.Stack;

/**
 * ClassName: PrintLinkedList
 * Description:
 * 从尾到头打印链表
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * date: 2020/12/11 12:44 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class PrintLinkedList {

    /**
     * 使用栈
     * time：o(n)
     * space：o(n)
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        int size = stack.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = stack.pop().val;
        }
        return result;
    }
}
