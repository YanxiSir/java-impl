package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.InterviewQuestion;
import com.yanxisir.leetcode.zannos.NeedReview;
import com.yanxisir.leetcode.zannos.Remember;
import com.yanxisir.leetcode.zmodel.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * @author: YanxiSir
 * @Date: 2020/2/19
 * @Sign: 心中田间，木行水上
 */
@Remember
@NeedReview
@InterviewQuestion
public class Q94 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        TreeNode root = (TreeNode) args[0];
//        return solution1(root);
        return solution2(root);
    }

    // 递归
    private List<Integer> solution1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursive(root, list);
        return list;
    }

    private void recursive(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        recursive(node.left, list);
        list.add(node.val);
        recursive(node.right, list);
    }

    // 迭代
    private List<Integer> solution2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            cur = node.right;
        }
        return list;
    }

    // 莫里斯遍历（二叉树线索化）
    private List<Integer> solution3(TreeNode root) {
        return null;
    }
}
