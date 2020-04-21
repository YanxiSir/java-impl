package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author: YanxiSir
 * @Date: 2020/4/19
 * @Sign: 心中田间，木行水上
 */
@Deprecated
public class Q17 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        String digits = (String) args[0];
        return solution1(digits);
    }


    protected List<String> solution1(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        System.out.println((int) 'a');
        return null;
    }
}
