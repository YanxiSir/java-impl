package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;

/**
 * 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author: YanxiSir
 * @date: 2020/5/3
 * @sign: help yourself
 */
public class Q5 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        String s = (String) args[0];
        return solution1(s);
    }

    // 中心扩展法
    protected String solution1(String s) {
        if (s.length() == 0) {
            return "";
        }
        char[] as = s.toCharArray();
        int n = s.length();
        String ret = String.valueOf(as[0]);
        int max = 1;
        for (int i = 0; i < n; i++) {
            // 奇数回文
            String tmp = String.valueOf(as[i]);
            Integer tmpMax = 1;
            int l = i - 1, r = i + 1;
            while (l >= 0 && r <= n - 1) {
                if (as[l] != as[r]) {
                    break;
                }
                tmp = as[l] + tmp + as[l];
                tmpMax += 2;
                if (tmpMax >= max) {
                    max = tmpMax;
                    ret = tmp;
                }
                l--;
                r++;
            }
            // 偶数回文
            l = i;
            r = i + 1;
            tmpMax = 0;
            tmp = "";
            while (l >= 0 && r <= n - 1) {
                if (as[l] != as[r]) {
                    break;
                }
                tmp = as[l] + tmp + as[l];
                tmpMax += 2;
                if (tmpMax >= max) {
                    max = tmpMax;
                    ret = tmp;
                }
                l--;
                r++;
            }
        }
        return ret;
    }

}
