package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Remember;
import com.yanxisir.leetcode.zannos.Tag;

import java.util.*;

/**
 * 组合总和 II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * @author: YanxiSir
 * @Date: 2020/4/19
 * @Sign: 心中田间，木行水上
 */
@Tag({"组合", "回溯+剪枝"})
@Remember
public class Q40 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int[] candidates = (int[]) args[0];
        int target = (int) args[1];
        return solution1(candidates, target);
    }

    /**
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 所求解集为:
     * [
     * [1,2,2],
     * [5]
     * ]
     */
    protected List<List<Integer>> solution1(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        s1(candidates, candidates.length, target, 0, new ArrayDeque<>(candidates.length), res);
        return res;
    }

    protected void s1(int[] candidates, int len, int left, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (left == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (begin >= len) {
            return;
        }
        Integer cur = null;
        for (int i = begin; i < len; i++) {
            // 大剪枝
            if (candidates[i] > left) {
                break;
            }
            // 小剪枝
//            if (i > begin && candidates[i] == candidates[i - 1]) {
//                continue;
//            }
            if (cur != null && candidates[i] == cur) {
                continue;
            }
            path.addLast(candidates[i]);
            s1(candidates, len, left - candidates[i], i + 1, path, res);
            path.removeLast();
            cur = candidates[i];
        }
    }
}
