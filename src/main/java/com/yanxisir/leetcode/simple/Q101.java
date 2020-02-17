package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zmodel.TreeNode;

/**
 * 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author: YanxiSir
 * @Date: 2020/2/13
 * @Sign: 心中田间，木行水上
 */
public class Q101 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        TreeNode root = (TreeNode) args[0];
        return solution1(root);
    }


    private Object solution1(TreeNode root) {
        return compare(root, root);
    }

    private boolean compare(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && compare(t1.left, t2.right) && compare(t1.right, t2.left);
    }
}
