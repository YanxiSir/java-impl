package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zmodel.ListNode;

/**
 * 链表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * @author: YanxiSir
 * @date: 2020/5/8
 * @sign: help yourself
 */
public class Q876 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        ListNode head = (ListNode) args[0];
        return solution1(head);
    }

    protected ListNode solution1(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
