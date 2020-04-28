package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.DynamicPrograming;
import com.yanxisir.leetcode.zannos.Remember;
import com.yanxisir.leetcode.zannos.Tag;

/**
 * 一和零
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 *
 * @author: YanxiSir
 * @Date: 2020/4/16
 * @Sign: 心中田间，木行水上
 */
@Tag({"01"})
@Remember
@DynamicPrograming
public class Q474 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        String[] strs = (String[]) args[0];
        int m = (int) args[1];
        int n = (int) args[2];
        return solution1(strs, m, n);
    }

    protected int solution1(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] zo = cc(s);
            for (int i = m; i >= zo[0]; i--) {
                for (int j = n; j >= zo[1]; j--) {
                    dp[i][j] = Math.max(1 + dp[i - zo[0]][j - zo[1]], dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    protected int[] cc(String s) {
        int[] a = new int[2];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c == '0') {
                a[0]++;
            } else {
                a[1]++;
            }
        }
        return a;
    }
}
