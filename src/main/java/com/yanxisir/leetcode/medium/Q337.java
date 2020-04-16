package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.DynamicPrograming;
import com.yanxisir.leetcode.zannos.Tag;
import com.yanxisir.leetcode.zmodel.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 打家劫舍 III
 * https://leetcode-cn.com/problems/house-robber-iii/
 *
 * @author: YanxiSir
 * @Date: 2020/4/15
 * @Sign: 心中田间，木行水上
 */
@Tag({"树形动态规划"})
@DynamicPrograming
public class Q337 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        TreeNode root = (TreeNode) args[0];
        return solution1(root);
    }

    // 递归+缓存重复子问题的解
    protected int solution1(TreeNode root) {
        Map<TreeNode, Integer> memo = new HashMap<>();
        return s1(root, memo);
    }

    private int s1(TreeNode node, Map<TreeNode, Integer> memo) {
        if (node == null) {
            return 0;
        }
        if (memo.containsKey(node)) {
            return memo.get(node);
        }
        // 爷爷
        int money = node.val;
        if (node.left != null) {
            // 孙子
            money += s1(node.left.left, memo) + s1(node.left.right, memo);
        }
        if (node.right != null) {
            // 孙子
            money += s1(node.right.left, memo) + s1(node.right.right, memo);
        }
        int ret = Math.max(money, s1(node.left, memo) + s1(node.right, memo));
        memo.put(node, ret);
        return ret;
    }

    // 0-不偷；1-偷
    protected int solution2(TreeNode root) {
        int[] ret = s2(root);
        return Math.max(ret[0], ret[1]);
    }

    private int[] s2(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int[] ret = new int[2];
        int[] left = s2(node.left);
        int[] right = s2(node.right);
        ret[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        ret[1] = left[0] + right[0] + node.val;
        return ret;
    }
}
