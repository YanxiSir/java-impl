package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;

/**
 * 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author: YanxiSir
 * @Date: 2020/4/21
 * @Sign: 心中田间，木行水上
 */
@Deprecated
public class Q11 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int[] height = (int[]) args[0];
        return solution1(height);
    }

    protected int solution1(int[] height) {
        return 0;
    }
}
