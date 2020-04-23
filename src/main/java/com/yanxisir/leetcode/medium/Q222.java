package com.yanxisir.leetcode.medium;

import com.google.common.base.Joiner;
import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Tag;
import com.yanxisir.leetcode.zmodel.TreeNode;

/**
 * 完全二叉树的节点个数
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 *
 * @author: YanxiSir
 * @Date: 2020/4/21
 * @Sign: 心中田间，木行水上
 */
@Tag({"二分", "递归"})
public class Q222 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        TreeNode root = (TreeNode) args[0];
        return solution1(root);
    }

    // 递归
    protected int solution1(TreeNode root) {
        return root == null ? 0 : 1 + solution1(root.left) + solution1(root.right);
    }

    // 递归
    protected int solution2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = height2(root.left);
        int r = height2(root.right);
        if (l == r) {
            return solution2(root.right) + (int) Math.pow(2, l);
        } else {
            return solution2(root.left) + (int) Math.pow(2, r);
        }
    }

    protected int height2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h = 0;
        TreeNode tmp = root;
        while (tmp != null) {
            h++;
            tmp = tmp.left;
        }
        return h;
    }

    // 二分
    protected int solution3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int d = 0;
        TreeNode tmp = root;
        while (tmp.left != null) {
            d++;
            tmp = tmp.left;
        }
        if (d == 0) {
            return 1;
        }
        int left = 1, right = (int) Math.pow(2, d) - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (exist(mid, d, root)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) Math.pow(2, d) - 1 + left;
    }

    private boolean exist(int mid, int d, TreeNode node) {
        int left = 0, right = (int) Math.pow(2, d) - 1;
        int em;
        for (int i = 0; i < d; i++) {
            em = left + (right - left) / 2;
            if (mid <= em) {
                node = node.left;
                right = em;
            } else {
                node = node.right;
                left = em + 1;
            }
        }
        return node != null;
    }
}
