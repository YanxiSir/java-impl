package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zmodel.ListNode;

/**
 * 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class Q2 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        ListNode l1 = (ListNode) args[0];
        ListNode l2 = (ListNode) args[1];
        return solution1(l1, l2);
    }

    protected ListNode solution1(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode curNode = null;
        int add = 0;
        while (l1 != null || l2 != null) {
            int l1val = l1 != null ? l1.val : 0;
            int l2val = l2 != null ? l2.val : 0;
            int total = l1val + l2val + add;
            int curVal = total % 10;
            add = total / 10;
            ListNode tmpNode = new ListNode(curVal);
            if (root == null) {
                root = tmpNode;
                curNode = tmpNode;
            } else {
                curNode.next = tmpNode;
                curNode = tmpNode;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (add != 0) {
            curNode.next = new ListNode(add);
        }
        return root;
    }
}
