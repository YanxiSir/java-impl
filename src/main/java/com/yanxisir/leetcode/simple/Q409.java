package com.yanxisir.leetcode.simple;

import com.google.common.collect.Maps;
import com.yanxisir.leetcode.AbstractQ;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-palindrome/
 *
 * @author: YanxiSir
 * @Date: 2020/2/4
 * @Sign: 心中田间，木行水上
 */
public class Q409 extends AbstractQ {

    @Override
    public Object run(String... args) {
        String s = args[0];
        return solution1(s);
//        return solution2(s);
    }

    private Object solution1(String s) {
        char[] cs = new char[58];
        int len = 0;
        for (char c : s.toCharArray()) {
            cs[c - 'A']++;
            if (cs[c - 'A'] == 2) {
                len += 2;
                cs[c - 'A'] = 0;
            }
        }
        return len < s.length() ? len + 1 : len;
    }

    @Deprecated
    private Object solution2(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            String k = String.valueOf(c);
            if (!map.containsKey(k)) {
                map.put(k, 1);
                continue;
            }
            map.put(k, map.get(k) + 1);
        }
        boolean addOne = false;
        int len = 0;
        for (Integer i : map.values()) {
            boolean flag = i % 2 == 1;
            if (!addOne && flag) {
                addOne = true;
            }
            len += flag ? i - 1 : i;
        }
        return addOne ? len + 1 : len;
    }
}
