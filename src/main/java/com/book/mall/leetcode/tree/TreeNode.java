package com.book.mall.leetcode.tree;

/**
 * ClassName: TreeNode
 * Description:
 * date: 2020/12/7 12:13 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

