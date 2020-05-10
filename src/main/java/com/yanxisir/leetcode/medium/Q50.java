package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;

/**
 * Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 *
 * @author: YanxiSir
 * @date: 2020/5/10
 * @sign: help yourself
 */
public class Q50 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        double x = (double) args[0];
        int n = (int) args[1];
        return solution1(x, n);
    }

    protected double solution1(double x, int n) {
        int n_n = Math.abs(n);
        double ret = myPow(x, n_n);
        return n > 0 ? ret : 1 / ret;
    }

    private double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double ret = myPow(x, n / 2);
        return n % 2 == 0 ? ret * ret : ret * ret * x;
    }

}
