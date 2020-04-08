package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Remember;

/**
 * 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author: YanxiSir
 * @Date: 2020/2/21
 * @Sign: 心中田间，木行水上
 */
@Remember
public class Q53 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
        return solution3(nums);
    }

    // 动态规划(时间复杂度：O(n), 空间复杂度：O(n))
    protected int solution1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 动态规划(时间复杂度：O(n), 空间复杂度：O(1))
    protected int solution2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i - 1] + nums[i];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    // 贪心算法(时间复杂度：O(n), 空间复杂度：O(1))
    protected int solution3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            max = Math.max(max, curSum);
        }
        return max;
    }

    // 分治法（时间复杂度：O(Nlog(N)), 空间复杂度：O(log(N))）
    protected int solution4(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int p = (l + r) / 2;
        int ls = helper(nums, l, p);
        int rs = helper(nums, p + 1, r);
        int cs = cross(nums, l, r, p);
        return Math.max(Math.max(ls, rs), cs);
    }

    private int cross(int[] nums, int l, int r, int p) {
        if (l == r) {
            return nums[r];
        }
        int lmx = Integer.MIN_VALUE;
        int ls = 0;
        for (int i = p; i > l - 1; --i) {
            ls += nums[i];
            lmx = Math.max(lmx, ls);
        }
        int rmx = Integer.MIN_VALUE;
        int rs = 0;
        for (int i = p + 1; i <= r; i++) {
            rs += nums[i];
            rmx = Math.max(rmx, rs);
        }
        return lmx + rmx;
    }
}
