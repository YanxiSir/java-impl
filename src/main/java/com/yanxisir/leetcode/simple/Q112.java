package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zmodel.TreeNode;

/**
 * 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 *
 * @author: YanxiSir
 * @Date: 2020/4/19
 * @Sign: 心中田间，木行水上
 */
public class Q112 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        TreeNode root = (TreeNode) args[0];
        int sum = (int) args[1];
        return solution1(root, sum);
    }

    protected boolean solution1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return helper(root, sum, 0);
    }

    private boolean helper(TreeNode node, int sum, int addTotal) {
        if (node == null && addTotal == sum) {
            return true;
        } else if (node == null) {
            return false;
        }
        int now = addTotal + node.val;
        boolean leftFlag = helper(node.left, sum, now);
        boolean rightFlat = helper(node.right, sum, now);
        if (node.left != null && node.right == null) {
            return leftFlag;
        }
        if (node.left == null && node.right != null) {
            return rightFlat;
        }
        return leftFlag || rightFlat;
    }
}
