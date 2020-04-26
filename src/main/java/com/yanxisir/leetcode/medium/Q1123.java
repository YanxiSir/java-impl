package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Tag;
import com.yanxisir.leetcode.zmodel.TreeNode;

/**
 * 最深叶节点的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves/
 *
 * @author: YanxiSir
 * @Date: 2020/2/13
 * @Sign: 心中田间，木行水上
 */
@Tag("递归")
public class Q1123 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        TreeNode root = (TreeNode) args[0];
        return solution1(root);
    }

    protected TreeNode solution1(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info res = helper(root);
        return res.node;
    }

    private Info helper(TreeNode node) {

        Info res = new Info(0, node);
        if (node == null) {
            return res;
        }
        Info l = helper(node.left);
        Info r = helper(node.right);
        if (l.dep == r.dep) {
            res.node = node;
            res.dep = l.dep + 1;
        } else {
            res.dep = Math.max(l.dep, r.dep) + 1;
            if (l.dep < r.dep) {
                res.node = r.node;
            } else {
                res.node = l.node;
            }
        }
        return res;
    }

    class Info {
        int dep;
        TreeNode node;

        public Info(int dep, TreeNode node) {
            this.dep = dep;
            this.node = node;
        }
    }
}
