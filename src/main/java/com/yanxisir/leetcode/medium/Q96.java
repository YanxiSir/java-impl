package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.DynamicPrograming;
import com.yanxisir.leetcode.zannos.Remember;
import com.yanxisir.leetcode.zannos.Tag;

/**
 * 不同的二叉搜索树
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 * @author: YanxiSir
 * @Date: 2020/4/26
 * @Sign: 心中田间，木行水上
 */
@Tag({"二叉搜索树", "动态规划"})
@Remember
@DynamicPrograming
public class Q96 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        int n = (int) args[0];
        return solution1(n);
    }

    protected int solution1(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
