package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Tag;
import com.yanxisir.leetcode.zmodel.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author: YanxiSir
 * @Date: 2020/2/18
 * @Sign: 心中田间，木行水上
 */
@Tag({"BFS"})
public class Q104 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        TreeNode root = (TreeNode) args[0];
//        return solution1(root);
        return solution2(root);
    }

    // 递归
    private int solution1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(solution1(root.left), solution1(root.right));
    }

    // 迭代
    private int solution2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));
        int depth = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            Integer nodeLen = pair.getValue();
            depth = Math.max(depth, nodeLen);
            if (node.left != null) {
                queue.add(new Pair<>(node.left, nodeLen + 1));
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, nodeLen + 1));
            }
        }
        return depth;
    }

}
