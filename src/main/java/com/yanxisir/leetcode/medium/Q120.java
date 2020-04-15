package com.yanxisir.leetcode.medium;

import com.alibaba.fastjson.JSON;
import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.DynamicPrograming;
import com.yanxisir.leetcode.zannos.Remember;

import java.util.List;

/**
 * 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/description/
 *
 * @author: YanxiSir
 * @Date: 2020/2/21
 * @Sign: 心中田间，木行水上
 */
@Remember
@DynamicPrograming
public class Q120 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        List<List<Integer>> triangle = (List<List<Integer>>) args[0];
        return solution3(triangle);
    }

    // 空间复杂度 O(1)
    protected int solution1(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        // 记录每一行的选择
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
//                int top_l = 0;
//                if (j > 0) {
//                    top_l = j - 1;
//                }
//                int top_r = j;
//                if (top_r > triangle.get(i - 1).size() - 1) {
//                    top_r = triangle.get(i - 1).size() - 1;
//                }
//                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(top_l), triangle.get(i - 1).get(top_r)));

                // 更好理解
                int su = 0;
                if (j == 0) {
                    su = triangle.get(i - 1).get(0);
                } else if (j == (triangle.get(i).size() - 1)) {
                    su = triangle.get(i - 1).get(triangle.get(i - 1).size() - 1);
                } else {
                    su = Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j));
                }
                triangle.get(i).set(j, triangle.get(i).get(j) + su);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            min = Math.min(min, triangle.get(triangle.size() - 1).get(i));
        }
        return min;
    }

    // 空间复杂度 O(n)， 自下而上的dp
    protected int solution2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // 初始值都是0
        int[] dp = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j);
            }
        }
        return dp[0];
    }

    // 空间复杂度 O(n)， 自上而下的dp
    protected int solution3(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // 初始值都是0
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        // prev暂存dp[i-1][j-1],cur暂存dp[i-1][j]
        int prev = 0, cur;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                cur = dp[j];
                if (j == 0) {
                    dp[j] = cur + row.get(j);
                } else if (j == i) {
                    dp[j] = prev + row.get(j);
                } else {
                    dp[j] = Math.min(cur, prev) + row.get(j);
                }
                prev = cur;
            }
        }
        int res = Integer.MAX_VALUE;
        // dp最后一行记录了最小路径
        for (int i = 0; i < triangle.size(); i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }

}
