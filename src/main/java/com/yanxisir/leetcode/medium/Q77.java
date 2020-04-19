package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Remember;
import com.yanxisir.leetcode.zannos.Tag;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 组合
 * https://leetcode-cn.com/problems/combinations/
 *
 * @author: YanxiSir
 * @Date: 2020/4/19
 * @Sign: 心中田间，木行水上
 */
@Tag("组合")
@Remember
public class Q77 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int n = (int) args[0];
        int k = (int) args[1];
        return solution1(n, k);
    }

    /**
     * 输入: n = 4, k = 2
     * 输出:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     */
    protected List<List<Integer>> solution1(int n, int k) {
        if (n <= 0 || k <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        s1(n, k, 1, 0, new ArrayDeque<>(), res);
        return res;
    }

    private void s1(int n, int k, int cur, int pos, Deque<Integer> path, List<List<Integer>> res) {
        if (pos == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = cur; i <= n; i++) {
            path.add(i);
            s1(n, k, i + 1, pos + 1, path, res);
            path.removeLast();
        }
    }


}
