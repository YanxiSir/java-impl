package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zmodel.TreeNode;

/**
 * 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * @author: YanxiSir
 * @Date: 2020/2/19
 * @Sign: 心中田间，木行水上
 */
public class Q110 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        TreeNode root = (TreeNode) args[0];
        return solution1(root);
    }

    private boolean solution1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) < 2
                && solution1(root.left) && solution1(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
