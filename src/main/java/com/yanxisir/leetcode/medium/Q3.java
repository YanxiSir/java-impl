package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;

import java.util.*;

/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author: YanxiSir
 * @date: 2020/5/3
 * @sign: help yourself
 */
public class Q3 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        String s = (String) args[0];
        return solution1(s);
    }

    protected int solution1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 1;
        // 记录当前已有的字符
        Deque<Character> deque = new LinkedList<>();
        char[] as = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            while (deque.contains(as[i])) {
                deque.removeFirst();
            }
            // 不存在，说明还没重复
            deque.addLast(as[i]);
            max = Math.max(max, deque.size());
        }
        return max;
    }

    // hashmap实现
    protected int solution2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 1, left = 0;
        // 记录当前已有的字符
        Map<Character, Integer> map = new HashMap<>();
        char[] as = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(as[i])) {
                left = Math.max(left, map.get(as[i]) + 1);
            }
            // 不存在，说明还没重复
            map.put(as[i], i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
