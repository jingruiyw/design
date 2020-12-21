package com.book.mall.code.linkedlist;

import lombok.Data;

/**
 * ClassName: ListNode
 * Description: 单链表
 * date: 2020/5/27 2:16 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
@Data
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
