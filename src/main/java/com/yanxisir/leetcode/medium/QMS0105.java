package com.yanxisir.leetcode.medium;

import com.google.common.collect.Lists;
import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.DynamicPrograming;

import java.util.List;

/**
 * 面试题 01.05. 一次编辑
 * https://leetcode-cn.com/problems/one-away-lcci/
 *
 * @author: YanxiSir
 * @Date: 2020/4/26
 * @Sign: 心中田间，木行水上
 */
@DynamicPrograming
public class QMS0105 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        String first = (String) args[0];
        String second = (String) args[1];
        return solution1(first, second);
    }

    protected boolean solution1(String first, String second) {
        int l1 = first.length();
        int l2 = second.length();
        if (Math.abs(l1 - l2) >= 2) {
            return false;
        } else if (l1 == 0 || l2 == 0) {
            return true;
        }
        if (first.equals(second)) {
            return true;
        }
        // 求最长公共子串
        char[] c1 = first.toCharArray();
        char[] c2 = second.toCharArray();
        if (l1 == l2) {
            int len = 0, cur = 0;
            while (cur < l1 && ((c1[cur] == c2[cur]) || len < 2)) {
                if (c1[cur] != c2[cur]) {
                    len++;
                }
                cur++;
            }
            if (len == 2) {
                return false;
            }
        }
        int[][] dp = new int[c1.length + 1][c2.length + 1];
        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                dp[i][j] = c1[i - 1] == c2[j - 1] ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return ((l1 != l2 && dp[c1.length][c2.length] == Math.min(l1, l2)));
    }

    @Override
    protected List<Class> related() {
        return Lists.newArrayList(Q1143.class);
    }
}
