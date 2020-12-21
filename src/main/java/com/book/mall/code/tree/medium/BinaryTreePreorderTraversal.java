package com.book.mall.code.tree.medium;

import com.book.mall.code.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: BinaryTreePreorderTraversal
 * Description:
 * 144. 二叉树的前序遍历
 * <p>
 * date: 2020/12/13 11:55 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class BinaryTreePreorderTraversal {


    /**
     * 使用栈
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                result.add(treeNode.val);
                //把自己放进栈
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            if (!stack.isEmpty()) {
                //回溯一次
                treeNode = stack.pop();
                //取回溯后的右节点
                treeNode = treeNode.right;
            }
        }
        return result;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(result, root);
        return result;
    }

    //递归
    public void preOrder(List<Integer> result, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        result.add(treeNode.val);
        preOrder(result, treeNode.left);
        preOrder(result, treeNode.right);
    }
}
