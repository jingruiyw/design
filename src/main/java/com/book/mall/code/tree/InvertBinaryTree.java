package com.book.mall.code.tree;

import java.util.Stack;

/**
 * ClassName: InvertBinaryTree
 * Description:
 * 226. 翻转二叉树
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * date: 2022/5/20 5:02 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class InvertBinaryTree {

    /**
     * 非递归
     *
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node = root;
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
            TreeNode left = root.left;
            root.left = root.right;
            root.right = left;
        }
        return node;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            invert(root.left);
        }
        if (root.right != null) {
            invert(root.right);
        }
        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;
    }
}
