package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zmodel.ListNode;

import java.util.Stack;

/**
 * 两数相加 II
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 *
 * @author: YanxiSir
 * @Date: 2020/3/5
 * @Sign: 心中田间，木行水上
 */
public class Q445 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        ListNode l1 = (ListNode) args[0];
        ListNode l2 = (ListNode) args[1];
        return solution1(l1, l2);
    }

    // 1、单链表反转
    protected ListNode solution1(ListNode l1, ListNode l2) {
        // 反转两个链表
        ListNode rl1 = revert(l1);
        ListNode rl2 = revert(l2);

        int addW = 0;
        // 以rl1为基准
        ListNode retNode = rl1;
        ListNode rl1Pre = null;
        while (rl1 != null && rl2 != null) {
            int val = rl1.val + rl2.val + addW;
            rl1.val = val % 10;
            addW = val / 10;
            rl1Pre = rl1;
            rl1 = rl1.next;
            rl2 = rl2.next;
        }
        if (rl2 != null) {
            rl1Pre.next = rl2;
            rl1 = rl2;
        }
        if (rl1 == null && addW > 0) {
            rl1Pre.next = new ListNode(addW);
        }
        while (rl1 != null) {
            int val = rl1.val + addW;
            rl1.val = val % 10;
            addW = val / 10;
            rl1Pre = rl1;
            rl1 = rl1.next;
        }
        if (addW > 0) {
            rl1Pre.next = new ListNode(addW);
        }
        return revert(retNode);
    }

    private ListNode revert(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    // 2、不翻转，借用栈实现
    protected ListNode solution2(ListNode l1, ListNode l2) {

        return null;
    }

}
