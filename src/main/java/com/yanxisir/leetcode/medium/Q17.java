package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author: YanxiSir
 * @Date: 2020/4/19
 * @Sign: 心中田间，木行水上
 */
public class Q17 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        String digits = (String) args[0];
        return solution1(digits);
    }

    Map<Integer, String> numberMap = new HashMap<Integer, String>() {
        {
            put(2, "abc");
            put(3, "def");
            put(4, "ghi");
            put(5, "jkl");
            put(6, "mno");
            put(7, "pqrs");
            put(8, "tuv");
            put(9, "wxyz");
        }
    };


    protected List<String> solution1(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        String path = "";
        helper(digits.toCharArray(), digits.length(), 0, path, res);
        return res;
    }

    private void helper(char[] cs, int len, int index, String path, List<String> res) {
        if (index == len) {
            res.add(path);
            return;
        }
        String ss = numberMap.get(Integer.parseInt(String.valueOf(cs[index])));
        if (ss == null) {
            helper(cs, len, index + 1, path, res);
        } else {
            for (char c : ss.toCharArray()) {
                helper(cs, len, index + 1, path + c, res);
            }
        }
    }
}
