package com.book.mall.code.tree.medium;

import com.book.mall.code.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: BinaryTreeLevelOrderTraversal
 * Description:
 * 102. 二叉树的层序遍历
 * date: 2020/12/14 2:35 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class BinaryTreeLevelOrderTraversal {


    /**
     * 二叉树的广度优先遍历：递归实现
     * time: o(n)
     * space: o(n)
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        //用来存放最终结果
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //需要每次带一个行下去,如果该行没有list则创建一个list
        if (root == null) {
            return res;
        }
        level(root, 1, res);
        return res;
    }

    /**
     * 递归方法
     *
     * @param root
     * @param index
     */
    private void level(TreeNode root, int index, List<List<Integer>> res) {
        if (res.size() < index) {
            res.add(new ArrayList<>());
        }
        //将当前节点的值加入到res中，index代表当前层，假设index是3，节点值是99
        //res是[ [1],[2,3] [4] ]，加入后res就变为 [ [1],[2,3] [4,99] ]
        res.get(index - 1).add(root.val);
        //递归的处理左子树，右子树，同时将层数index+1,当左右子树都为null时，递归停止
        if (root.left != null) {
            level(root.left, index + 1, res);
        }
        if (root.right != null) {
            level(root.right, index + 1, res);
        }
    }

    /**
     * 二叉树的广度优先遍历：迭代
     * 使用队列个数n来判断是否换行
     * time: o(n)
     * space: o(n)
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //使用队列
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode treeNode = root;
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            //使用一个数值来判断是否换行
            int n = queue.size();
            List<Integer> data = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                treeNode = queue.poll();
                data.add(treeNode.val);
                //左右孩子分别入队
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                if (i == n - 1) {
                    result.add(data);
                }
            }
        }
        return result;
    }
}
