package com.book.mall.code.tree.medium;

import com.book.mall.code.linkedlist.ListNode;
import com.book.mall.code.tree.TreeNode;

import java.util.*;

/**
 * ClassName: BinaryTreeInorderTraversal
 * Description: 二叉树的中序遍历
 * <p>
 * date: 2020/12/7 12:06 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode treeNode = root;
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode = stack.pop();
            res.add(treeNode.val);
            treeNode = treeNode.right;
        }
        return res;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(res, root);
        return res;
    }

    public static void inOrder(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(res, root.left);
        res.add(root.val);
        inOrder(res, root.right);
    }

    /**
     * 1、递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            //终止的条件是节点为null
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    /**
     * 2、栈
     *
     * @param root
     * @return
     */
    public List<Integer> inorderStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        //根节点不为null 或者 栈不为空
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
