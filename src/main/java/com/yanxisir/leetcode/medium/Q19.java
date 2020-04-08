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
@Deprecated
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
    private Object solution2(ListNode head, int n){
        return null;
    }

    // 一次遍历，双指针
    private Object solution3(ListNode head, int n){
        return null;
    }
}
