package com.yanxisir.leetcode.medium;

import com.google.common.collect.Lists;
import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.simple.Q107;
import com.yanxisir.leetcode.zannos.NeedReview;
import com.yanxisir.leetcode.zannos.Tree;
import com.yanxisir.leetcode.zmodel.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @author: YanxiSir
 * @Date: 2020/2/17
 * @Sign: 心中田间，木行水上
 */
@Tree
@NeedReview
public class Q102 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        TreeNode root = (TreeNode) args[0];
//        return solution1(root);
        return solution2(root);
    }

    public List<List<Integer>> solution1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        // 全局queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // level-queue
            int queueLen = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < queueLen; i++) {
                TreeNode tmp = queue.poll();
                level.add(tmp.val);
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            list.add(level);
        }
        return list;
    }

    List<List<Integer>> list = new ArrayList<>();

    protected List<List<Integer>> solution2(TreeNode root) {
        if (root == null) {
            return list;
        }
        helper(root, 0);
        return list;

    }

    private void helper(TreeNode node, int level) {
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(node.val);
        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }

    @Override
    protected List<Class> related() {
        return Lists.newArrayList(Q107.class);
    }
}
