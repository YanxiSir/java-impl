package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zmodel.TreeNode;

/**
 * 最深叶节点的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves/
 *
 * @author: YanxiSir
 * @Date: 2020/2/13
 * @Sign: 心中田间，木行水上
 */
@Deprecated
public class Q1123 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        TreeNode root = (TreeNode) args[0];
        return solution1(root);
    }

    private Object solution1(TreeNode node) {
        // @todo empty
        return null;
    }
}
