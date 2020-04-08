package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Remember;

import java.util.HashMap;
import java.util.Map;

/**
 * 分数到小数
 * https://leetcode-cn.com/problems/fraction-to-recurring-decimal/
 *
 * @author: YanxiSir
 * @Date: 2020/2/21
 * @Sign: 心中田间，木行水上
 */
@Remember
public class Q166 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        Integer numerator = (Integer) args[0];
        Integer denominator = (Integer) args[1];
        return solution1(numerator, denominator);
    }

    /**
     * points: 1、-2的32次方 转正整数会溢出.
     *
     * @param numerator
     * @param denominator
     * @return
     */
    private String solution1(int numerator, int denominator) {
        if (numerator == 0 || denominator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            result.append("-");
        }
        long num = Math.abs(Long.valueOf(numerator));
        long den = Math.abs(Long.valueOf(denominator));
        result.append(String.valueOf(num / den));
        long yu = num % den;
        if (yu == 0) {
            return result.toString();
        }
        result.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (yu != 0) {
            if (map.containsKey(yu)) {
                result.insert(map.get(yu), "(");
                result.append(")");
                break;
            }
            map.put(yu, result.length());
            yu *= 10;
            result.append(String.valueOf(yu / den));
            yu = yu % den;
        }
        return result.toString();
    }
}
