package com.yanxisir.leetcode.zmodel;

/**
 * @author: YanxiSir
 * @Date: 2020/4/18
 * @Sign: 心中田间，木行水上
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
