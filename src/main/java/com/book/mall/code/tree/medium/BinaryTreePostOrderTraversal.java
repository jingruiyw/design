package com.book.mall.code.tree.medium;

import com.book.mall.code.tree.TreeNode;

import java.util.*;

/**
 * ClassName: BinaryTreePostOrderTraversal
 * Description:
 * date: 2020/12/14 10:31 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class BinaryTreePostOrderTraversal {

    public List<Integer> postOrderTraversal5(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode treeNode = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        Stack<TreeNode> resStack = new Stack<>();

        while (!stack.isEmpty()) {
            treeNode = stack.pop();
            resStack.push(treeNode);
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
        }
        while (!resStack.isEmpty()) {
            res.add(resStack.pop().val);
        }
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder1(res, root);
        return res;
    }

    public static void postOrder1(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder1(res, root.left);
        postOrder1(res, root.right);
        res.add(root.val);
    }


    /**
     * 后序遍历非递归实现，目前觉得最简单的一种
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal4(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> resStack = new Stack<>();
        TreeNode treeNode;
        stack.push(root);
        //入栈的顺序是左右根，采用后序遍历的逆序
        while (!stack.isEmpty()) {
            treeNode = stack.pop();
            resStack.push(treeNode);
            //再放左
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
            //先放右
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
        }
        while (!resStack.isEmpty()) {
            result.add(resStack.pop().val);
        }
        return result;
    }


    /**
     * 练习
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        TreeNode prev = null;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                if (treeNode.right == null || treeNode.right == prev) {
                    result.add(treeNode.val);
                    prev = treeNode;
                    treeNode = null;
                } else {
                    stack.push(treeNode);
                    treeNode = treeNode.right;
                }
            }
        }
        return result;
    }

    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return postOrder(result, root);
    }

    public List<Integer> postOrder(List<Integer> result, TreeNode treeNode) {
        if (treeNode == null) {
            return result;
        }
        postOrder(result, treeNode.left);
        postOrder(result, treeNode.right);
        result.add(treeNode.val);
        return result;
    }

    /**
     * 非递归实现，需要标志位来判断是否该弹出根节点
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        TreeNode prev = null;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                //当前节点作为根节点出栈的条件是：当前节点无右节点或者上一个访问的节点是右节点
                if (treeNode.right == null || treeNode.right == prev) {
                    //输出遍历的值
                    result.add(treeNode.val);
                    //更改下一个节点的prev
                    prev = treeNode;
                    //将节点置为null
                    treeNode = null;
                } else {
                    //此时还有右节点未遍历，把当前根节点再次放进栈中
                    stack.push(treeNode);
                    treeNode = treeNode.right;
                }
            }
        }
        return result;
    }
}
