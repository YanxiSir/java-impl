package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zmodel.ListNode;

import java.util.Stack;

/**
 * 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author: YanxiSir
 * @Date: 2020/3/5
 * @Sign: 心中田间，木行水上
 */
public class Q19 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        ListNode head = (ListNode) args[0];
        int n = (int) args[1];
        return solution1(head, n);
    }

    // 栈
    private Object solution1(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode curNode = head;
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.next;
        }
        int cur = 1;
        ListNode tmpNode = null;
        while (cur <= n) {
            tmpNode = stack.pop();
            cur++;
        }
        if (stack.isEmpty()) {
            return n == 1 ? null : tmpNode.next;
        }
        ListNode ln = stack.pop();
        if (tmpNode.next == null) {
            ln.next = null;
        } else {
            ln.next.val = tmpNode.next.val;
            ln.next.next = tmpNode.next.next;
        }
        return head;
    }

    // 两次遍历
    private Object solution2(ListNode head, int n) {
        // 第一遍：求出栈的长度，转换问题
        if (head == null || head.next == null) {
            return null;
        }
        int len = 0;
        ListNode tmpNode = head;
        while (tmpNode != null) {
            len++;
            tmpNode = tmpNode.next;
        }
        int delPos = len + 1 - n;
        if (delPos == 1) {
            return head.next;
        }
        int cur = 1;
        tmpNode = head;
        while (tmpNode != null) {
            if (cur == delPos - 1) {
                tmpNode.next = tmpNode.next.next;
                break;
            }
            tmpNode = tmpNode.next;
            cur++;
        }
        return head;
    }

    // 一次遍历，双指针
    private Object solution3(ListNode head, int n) {
        // 1,2,3,4,5       , 删除倒数第2个
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slowPre = null;
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (slowPre == null) {
            return slow.next;
        }
        slowPre.next = slow.next;
        return head;
    }
}
