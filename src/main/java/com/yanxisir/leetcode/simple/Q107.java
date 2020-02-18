package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.medium.Q102;
import com.yanxisir.leetcode.zmodel.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层次遍历 II
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 *
 * @author: YanxiSir
 * @Date: 2020/2/18
 * @Sign: 心中田间，木行水上
 */
public class Q107 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        TreeNode root = (TreeNode) args[0];
        return solution1(root);
    }


    private List<List<Integer>> solution1(TreeNode root) {
        List<List<Integer>> preOrderList = new Q102().solution1(root);
        List<List<Integer>> newOrderList = new ArrayList<>();
        for (int i = preOrderList.size() - 1; i >= 0; i--) {
            newOrderList.add(preOrderList.get(i));
        }
        return newOrderList;
    }


}
