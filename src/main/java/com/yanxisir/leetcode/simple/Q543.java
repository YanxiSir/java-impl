package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.InterviewQuestion;
import com.yanxisir.leetcode.zmodel.TreeNode;

/**
 * 二叉树的直径(二叉树最长路径)
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 *
 * @author: YanxiSir
 * @Date: 2020/2/25
 * @Sign: 心中田间，木行水上
 */
@InterviewQuestion
public class Q543 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        TreeNode root = (TreeNode) args[0];
        return solution1(root);
    }

    // 经过的点个数cc。路经长=cc-1
    int depth = 0;

    private int solution1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        nodeDepth(root);
        return depth - 1;
    }

    private int nodeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = nodeDepth(node.left);
        int r = nodeDepth(node.right);
        depth = Math.max(depth, l + r + 1);
        return 1 + Math.max(l, r);
    }
}
