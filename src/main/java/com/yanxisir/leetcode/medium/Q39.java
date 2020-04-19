package com.yanxisir.leetcode.medium;

import com.google.common.collect.Lists;
import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Remember;
import com.yanxisir.leetcode.zannos.Tag;

import java.util.*;

/**
 * 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * @author: YanxiSir
 * @Date: 2020/4/19
 * @Sign: 心中田间，木行水上
 */
@Tag("组合")
@Remember
public class Q39 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int[] candidates = (int[]) args[0];
        int target = (int) args[1];
        return solution1(candidates, target);
    }

    // 搜索
    protected List<List<Integer>> solution1(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    protected void helper(int[] candidates, int left, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (left == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            // 剪枝
            if (candidates[i] > left) {
                break;
            }
            path.add(candidates[i]);
            helper(candidates, left - candidates[i], i, path, res);
            path.removeLast();
        }
    }

    @Override
    protected List<Class> related() {
        return Lists.newArrayList(Q377.class, Q40.class, Q216.class, Q77.class);
    }
}
