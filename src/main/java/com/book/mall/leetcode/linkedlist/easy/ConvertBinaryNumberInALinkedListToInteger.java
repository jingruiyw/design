package com.book.mall.leetcode.linkedlist.easy;

import com.book.mall.leetcode.linkedlist.ListNode;

/**
 * ClassName: ConvertBinaryNumberInALinkedListToInteger
 * Description:
 * 1290.二进制链表转整数
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * <p>
 * date: 2020/6/28 1:30 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ConvertBinaryNumberInALinkedListToInteger {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        System.out.println(getDecimalValue(head));
        System.out.println(getDecimalValueV2(head));
    }

    /**
     * 2.位运算: 链表右移相当于二进制数左移
     *   换算成十进制数则是上一个十进制数x2 + 末位的二进制数
     *   eg: 101 = 5; 1010 = 10; 1011 = 11
     * time:O(n)
     * space:O(1)
     *
     * @param head
     * @return
     */
    private static int getDecimalValueV2(ListNode head) {
        int sum = 0;
        ListNode curr = head;
        while (curr != null) {
            sum = sum * 2 + curr.val;
            curr = curr.next;
        }
        return sum;
    }


    /**
     * 1.第一遍遍历出总数，第二遍求值
     * time:O(n)
     * space:O(1)
     *
     * @param head
     * @return
     */
    private static int getDecimalValue(ListNode head) {
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        int sum = 0;
        while (size != 0) {
            sum = (int) (sum + head.val * Math.pow(2, size - 1));
            size--;
            head = head.next;
        }
        return sum;
    }
}
