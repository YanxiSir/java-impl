package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.DynamicPrograming;
import com.yanxisir.leetcode.zannos.Remember;
import com.yanxisir.leetcode.zannos.Tag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 *
 * @author: YanxiSir
 * @Date: 2020/4/16
 * @Sign: 心中田间，木行水上
 */
@Tag({"01"})
@Remember
@DynamicPrograming
public class Q139 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        String s = (String) args[0];
        List<String> wordDict = (List<String>) args[1];
        return solution1(s, wordDict);
    }

    // 记忆化回溯
    protected boolean solution1(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return helper(s, new HashSet<>(wordDict), 0, memo);
    }

    protected boolean helper(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (s.length() == start) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && helper(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    // 动态规划
    protected boolean solution2(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
