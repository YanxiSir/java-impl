package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.NeedReview;
import com.yanxisir.leetcode.zmodel.ListNode;

/**
 * 删除链表中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *
 * @author: YanxiSir
 * @Date: 2020/2/23
 * @Sign: 心中田间，木行水上
 */
@NeedReview
public class Q237 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        ListNode root = (ListNode) args[0];
        return solution1(root);
    }

    private ListNode solution1(ListNode root) {
        root.val = root.next.val;
        root.next = root.next.next;
        return root;
    }
}
