package com.yanxisir.leetcode.medium;

import com.google.common.collect.Lists;
import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.DynamicPrograming;
import com.yanxisir.leetcode.zannos.Remember;
import com.yanxisir.leetcode.zannos.Tag;

import java.util.*;

/**
 * 组合总和 Ⅳ
 * https://leetcode-cn.com/problems/combination-sum-iv/
 *
 * @author: YanxiSir
 * @Date: 2020/3/2
 * @Sign: 心中田间，木行水上
 */
@Tag({"01"})
@Remember
@DynamicPrograming
public class Q377 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
        int target = (int) args[1];
        return solution4(nums, target);
    }

    //nums = [1, 2, 3]
    //target = 4
    protected int solution1(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i < target + 1; i++) {
            for (int j = 0; j < nums.length && nums[j] <= i; j++) {
                dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }

    protected int solution2(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target + 1; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    // 回溯法: 内存超限
    protected int solution3(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;

        }
        List<List<Integer>> res = new ArrayList<>();
        s3(nums, target, new ArrayDeque<>(), res);
        return res.size();
    }

    protected void s3(int[] nums, int left, Deque<Integer> path, List<List<Integer>> res) {
        if (left == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if (left < num) {
                continue;
            }
            path.add(num);
            s3(nums, left - num, path, res);
            path.removeLast();
        }
    }

    // 记忆化搜索：时间超限
    protected int solution4(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int[] memo = new int[target + 1];
        int[] dp = new int[target + 1];
        memo[0] = 0;
        s4(nums, target, new ArrayList<>(), memo);
        return memo[target];
    }

    protected void s4(int[] nums, int left, List<Integer> path, int[] memo) {
        if (left == 0) {
            int su = 0;
            for (int i = path.size() - 1; i >= 0; i--) {
                su += path.get(i);
                memo[su] = memo[su] + 1;
            }
            return;
        }
        for (int num : nums) {
            if (left < num) {
                continue;
            }
            path.add(num);
            s4(nums, left - num, path, memo);
            path.remove(path.size() - 1);
        }
    }

    @Override
    protected List<Class> related() {
        return Lists.newArrayList(Q39.class);
    }
}
