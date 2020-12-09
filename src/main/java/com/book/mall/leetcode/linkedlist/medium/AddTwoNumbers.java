package com.book.mall.leetcode.linkedlist.medium;

import com.book.mall.leetcode.bean.ListNode;

/**
 * ClassName: AddTwoNumbers
 * Description:
 * 2. 两数相加
 * 给出两个【非空】 的链表用来表示两个非负的整数。其中，它们各自的位数是按照【逆序】的方式存储的，并且它们的每个节点只能存储【一位】数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以【0】开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * date: 2020/12/9 3:36 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //边界条件
        if (l1 == null && l2 == null) {
            return null;
        }
        //因为已经是倒序
        //位数相加，需要考虑进位
        //位数不同
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int addOne = 0;
        //三个条件有一个存在就继续循环， l1 == null , l2 == null, addOne = 0;
        while (l1 != null || l2 != null || addOne != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + addOne;
            int val = sum % 10;
            head.next = new ListNode(val);
            //将头指针移动才能进行下去
            head = head.next;
            addOne = sum / 10;
            //需要对l1和l2进行判空来决定是否往下移动
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}
