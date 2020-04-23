package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zmodel.ListNode;

/**
 * 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * @author: YanxiSir
 * @Date: 2020/4/24
 * @Sign: 心中田间，木行水上
 */
public class Q203 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        ListNode head = (ListNode) args[0];
        int val = (int) args[1];
        return solution1(head, val);
    }

    protected ListNode solution1(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, cur = head;
        while (cur != null) {
            if (cur.val != val) {
                pre = cur;
            } else {
                if (pre != null) {
                    pre.next = cur.next;
                } else {
                    head = cur.next;
                }
            }
            cur = cur.next;
        }
        return head;
    }
}
