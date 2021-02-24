package com.yanxisir.leetcode.medium;

import com.google.common.collect.ImmutableMultimap;
import com.yanxisir.leetcode.AbstractQ;

import java.util.HashMap;
import java.util.Map;

/**
 * 整数转罗马数字
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
public class Q12 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int num = (int) args[0];
        return null;
    }

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private String solution1(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}
