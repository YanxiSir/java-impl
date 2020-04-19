package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Remember;
import com.yanxisir.leetcode.zannos.Tag;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 组合总和 III
 * https://leetcode-cn.com/problems/combination-sum-iii/
 *
 * @author: YanxiSir
 * @Date: 2020/4/19
 * @Sign: 心中田间，木行水上
 */
@Tag("组合")
@Remember
public class Q216 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int k = (int) args[0];
        int n = (int) args[1];
        return solution2(k, n);
    }

    protected List<List<Integer>> solution1(int k, int n) {
        if (n <= 0 || k <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        s1(n, k, 1, 0, new ArrayDeque<>(), res);
        return res;
    }

    private void s1(int n, int k, int cur, int pos, Deque<Integer> path, List<List<Integer>> res) {
        List<Integer> pathArray = new ArrayList<>(path);
        int su = 0;
        for (Integer num : pathArray) {
            su += num;
        }
        if (pos == k && su == n) {
            res.add(pathArray);

            return;
        }

        for (int i = cur; i <= 9; i++) {
            if (i > n - su) {
                break;
            }
            path.add(i);
            s1(n, k, i + 1, pos + 1, path, res);
            path.removeLast();
        }
    }


    protected List<List<Integer>> solution2(int k, int n) {
        if (n <= 0 || k <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        s2(n, k, 1, new ArrayDeque<>(), res);
        return res;
    }

    private void s2(int left, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (left < 0) {
            return;
        }
        if (left == 0 && k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= 9; i++) {
            path.add(i);
            s2(left - i, k - 1, i + 1, path, res);
            path.removeLast();
        }
    }
}
