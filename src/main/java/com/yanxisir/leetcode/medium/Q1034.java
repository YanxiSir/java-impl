package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;

/**
 * 边框着色
 * https://leetcode-cn.com/problems/coloring-a-border/
 *
 * @author: YanxiSir
 * @date: 2020/5/10
 * @sign: help yourself
 */
public class Q1034 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        int[][] grid = (int[][]) args[0];
        int r0 = (int) args[1];
        int c0 = (int) args[2];
        int color = (int) args[3];
        return solution1(grid, r0, c0, color);
    }

    protected int[][] solution1(int[][] grid, int r0, int c0, int color) {
        return null;
    }
}
