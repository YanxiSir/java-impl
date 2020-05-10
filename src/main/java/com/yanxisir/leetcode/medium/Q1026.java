package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zmodel.TreeNode;

/**
 * 节点与其祖先之间的最大差值
 * https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor/
 *
 * @author: YanxiSir
 * @date: 2020/5/10
 * @sign: help yourself
 */
public class Q1026 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        TreeNode root = (TreeNode) args[0];
        return solution1(root);
    }

    int maxDiff = 0;

    protected int solution1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        s1(root, root.val, root.val);
        return maxDiff;
    }

    protected void s1(TreeNode node, int maxVal, int minVal) {
        if (node == null) {
            return;
        }
        int localDiff = Math.max(Math.abs(maxVal - node.val), Math.abs(minVal - node.val));
        maxVal = Math.max(maxVal, node.val);
        minVal = Math.min(minVal, node.val);
        s1(node.left, maxVal, minVal);
        s1(node.right, maxVal, minVal);
        maxDiff = Math.max(maxDiff, localDiff);
    }
}
