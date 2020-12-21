package com.book.mall.code.linkedlist.easy;

import com.book.mall.code.linkedlist.ListNode;

/**
 * ClassName: DeleteNodeInALinkedList
 * Description:
 * 237. 删除链表中的节点
 * date: 2020/6/25 1:19 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class DeleteNodeInALinkedList {

    /**
     * 思路：将要删除的节点的下一个节点赋值到当前节点，然后把当前节点的next指向下一个节点的next
     * space:O(n)
     * time:O(1)
     *
     * @param node
     */
    private static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
