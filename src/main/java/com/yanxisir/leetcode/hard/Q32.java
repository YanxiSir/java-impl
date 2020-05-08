package com.yanxisir.leetcode.hard;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Remember;
import com.yanxisir.leetcode.zannos.Tag;

import java.util.Stack;

/**
 * 最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * @author: YanxiSir
 * @Date: 2020/2/21
 * @Sign: 心中田间，木行水上
 */
@Tag("栈")
@Remember
public class Q32 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        String s = (String) args[0];
        return solution1(s);
    }

    protected int solution1(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}
