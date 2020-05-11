package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;

/**
 * 我的日程安排表 I
 * https://leetcode-cn.com/problems/my-calendar-i/
 *
 * @author: YanxiSir
 * @date: 2020/5/11
 * @sign: help yourself
 */
public class Q729 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int start = (int) args[0];
        int end = (int) args[1];
        return solution1(start, end);
    }

    protected boolean solution1(int start, int end) {
        return false;
    }
}
