package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Remember;
import com.yanxisir.leetcode.zmodel.ListNode;

import java.util.Stack;

/**
 * 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author: YanxiSir
 * @Date: 2020/2/23
 * @Sign: 心中田间，木行水上
 */
@Remember
public class Q234 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        ListNode head = (ListNode) args[0];
        return solution2(head);
    }

    // 栈. 时间复杂度O(n), 空间复杂度O(n)
    protected boolean solution1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        tmp = head;
        while (tmp != null) {
            ListNode tmp2 = stack.pop();
            if (tmp.val != tmp2.val) {
                return false;
            }
            tmp = tmp.next;
        }
        return true;
    }

    // 时间复杂度O(n), 空间复杂度O(1)。 双指针+单链表反转
    protected boolean solution2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode midNode = midNode(head);
        ListNode revertNode = revert(midNode.next);

        while (head != null && revertNode != null) {
            if (head.val != revertNode.val) {
                return false;
            }
            head = head.next;
            revertNode = revertNode.next;
        }
        return true;
    }


    private ListNode revert(ListNode head) {
        ListNode pre = null;
        ListNode curNode = head;

        while (curNode != null) {
            ListNode tmpNode = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = tmpNode;
        }
        return pre;
    }

    private ListNode midNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
