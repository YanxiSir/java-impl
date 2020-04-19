package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Remember;
import com.yanxisir.leetcode.zmodel.Node;

import java.util.*;

/**
 * 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *
 * @author: YanxiSir
 * @Date: 2020/4/18
 * @Sign: 心中田间，木行水上
 */
@Remember
public class Q116 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        Node root = (Node) args[0];
        return solution1(root);
    }

    // 层次遍历 BFS
    protected Node solution1(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (pre == null) {
                    pre = node;
                } else {
                    pre.next = node;
                    pre = node;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return root;
    }
}
