package com.yanxisir.leetcode.medium;

import com.google.common.collect.Lists;
import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Remember;
import com.yanxisir.leetcode.zmodel.TreeNode;

import java.util.List;

/**
 * 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author: YanxiSir
 * @Date: 2020/2/13
 * @Sign: 心中田间，木行水上
 */
@Remember
public class Q236 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        TreeNode root = (TreeNode) args[0];
        TreeNode p = (TreeNode) args[1];
        TreeNode q = (TreeNode) args[2];
        return solution1(root, p, q);
    }

    protected TreeNode solution1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode l = solution1(root.left, p, q);
        TreeNode r = solution1(root.right, p, q);
        if (l != null && r != null) {
            return root;
        } else if (l != null) {
            return l;
        } else if (r != null) {
            return r;
        }
        return null;
    }


    @Override
    protected List<Class> related() {
        return Lists.newArrayList(
                Q1123.class
        );
    }
}
