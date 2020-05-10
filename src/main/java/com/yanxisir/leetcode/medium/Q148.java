package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zmodel.ListNode;

/**
 * 排序链表
 * https://leetcode-cn.com/problems/sort-list/
 *
 * @author: YanxiSir
 * @date: 2020/5/10
 * @sign: help yourself
 */
public class Q148 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        ListNode head = (ListNode) args[0];
        return solution1(head);
    }

    // 归并排序(递归)
    protected ListNode solution1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode ln = solution1(head);
        ListNode rn = solution1(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (ln != null && rn != null) {
            if (ln.val < rn.val) {
                res.next = ln;
                ln = ln.next;
            } else {
                res.next = rn;
                rn = rn.next;
            }
            res = res.next;
        }
        res.next = ln != null ? ln : rn;
        return h.next;
    }
}
