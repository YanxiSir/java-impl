package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zmodel.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 *
 * @author: YanxiSir
 * @Date: 2020/4/21
 * @Sign: 心中田间，木行水上
 */
public class Q257 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        TreeNode root = (TreeNode) args[0];
        return null;
    }

    //  递归1
    protected List<String> solution1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<Integer> path = new LinkedList<>();
        List<String> res = new ArrayList<>();
        path.add(root.val);
        helper(root, path, res);
        return res;
    }

    private void helper(TreeNode node, Deque<Integer> path, List<String> res) {
        if (node.left == null && node.right == null) {
            String s = list2string(path);
            if (s != "") {
                res.add(s);
            }
            return;
        }
        if (node.left != null) {
            path.add(node.left.val);
            helper(node.left, path, res);
            path.removeLast();
        }
        if (node.right != null) {
            path.add(node.right.val);
            helper(node.right, path, res);
            path.removeLast();
        }
    }

    private String list2string(Deque<Integer> path) {
        if (path == null || path.size() == 0) {
            return "";
        }
        String s = "";
        for (Integer i : path) {
            if (s != "") {
                s += "->";
            }
            s += i + "";
        }
        return s;
    }


    // 递归2
    protected List<String> solution2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        String path = "";
        List<String> res = new ArrayList<>();
        helper2(root, path, res);
        return res;
    }

    private void helper2(TreeNode node, String path, List<String> res) {
        if (node == null) {
            return;
        }
        path += node.val + "";
        if (node.left == null && node.right == null) {
            res.add(path);
        } else {
            path += "->";
            helper2(node.left, path, res);
            helper2(node.right, path, res);
        }
    }

    // 迭代 BFS
    protected List<String> solution3(TreeNode root) {
        return null;
    }
}
