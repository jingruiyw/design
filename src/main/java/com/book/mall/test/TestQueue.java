package com.book.mall.test;

import com.alibaba.fastjson.JSON;
import com.book.mall.code.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: TestQueue
 * Description:
 * date: 2021/6/11 10:59 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class TestQueue {

    public static void main(String[] args) {

        TreeNode left2 = new TreeNode(6);
        TreeNode right2 = new TreeNode(5);
        TreeNode left = new TreeNode(7, left2, null);
        TreeNode right = new TreeNode(3, null, right2);
        TreeNode node = new TreeNode(2, left, right);

        System.out.println(JSON.toJSONString(reverseTree(node)));

    }

    public static TreeNode reverseTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
                TreeNode left = node.left;
                node.left = node.right;
                node.right = left;
            }
        }
        return root;
    }
}
