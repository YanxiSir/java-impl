package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.DynamicPrograming;

/**
 * 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 *
 * @author: YanxiSir
 * @Date: 2020/2/21
 * @Sign: 心中田间，木行水上
 */
@DynamicPrograming
public class Q1143 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        String text1 = (String) args[0];
        String text2 = (String) args[1];
        return solution1(text1, text2);
    }

    protected int solution1(String text1, String text2) {
        char[] tc1 = text1.toCharArray();
        char[] tc2 = text2.toCharArray();
        if (tc1.length == 0 || tc2.length == 2) {
            return 0;
        }
        int[][] dp = new int[tc1.length + 1][tc2.length + 1];
        for (int i = 1; i <= tc1.length; i++) {
            for (int j = 1; j <= tc2.length; j++) {
                dp[i][j] = tc1[i - 1] == tc2[j - 1] ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[tc1.length][tc2.length];
    }
}
