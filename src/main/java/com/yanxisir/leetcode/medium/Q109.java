package com.yanxisir.leetcode.medium;

import com.google.common.collect.Lists;
import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.simple.Q108;
import com.yanxisir.leetcode.zmodel.ListNode;
import com.yanxisir.leetcode.zmodel.TreeNode;

import java.util.List;

/**
 * 有序链表转换二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * @author: YanxiSir
 * @Date: 2020/2/18
 * @Sign: 心中田间，木行水上
 */
public class Q109 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        ListNode root = (ListNode) args[0];
        return solution1(root);
    }

    private TreeNode solution1(ListNode root) {
        if (root == null) {
            return null;
        }
        return list2Tree(root);
    }


    private ListNode findMiddleNode(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode preNode = null;
        ListNode slowNode = node;
        ListNode fastNode = node;
        while (fastNode != null && fastNode.next != null) {
            preNode = slowNode;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        if (preNode != null) {
            preNode.next = null;
        }
        return slowNode;
    }

    private TreeNode list2Tree(ListNode node) {
        if(node==null){
            return null;
        }
        ListNode middleNode = findMiddleNode(node);
        TreeNode treeNode = new TreeNode(middleNode.val);
        if (node == middleNode) {
            return treeNode;
        }
        treeNode.left = list2Tree(node);
        treeNode.right = list2Tree(middleNode.next);
        return treeNode;
    }

    @Override
    protected List<Class> related() {
        return Lists.newArrayList(Q108.class);
    }
}
