package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;

/**
 * 在 D 天内送达包裹的能力
 * https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 *
 * @author: YanxiSir
 * @date: 2020/5/1
 * @sign: help yourself
 */
@Deprecated
public class Q1011 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        int[] weights = (int[]) args[0];
        int D = (int) args[1];
        return solution1(weights, D);
    }

    // 二分
    protected int solution1(int[] weights, int D) {
        int l = 0, r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (canShip(weights, D, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // 假设运载能力为k，判断是否符合提议（不一定是最优）
    private boolean canShip(int[] weights, int D, int k) {
        int left = k; // 剩余运载能力
        for (int weight : weights) {
            if (weight > k) {
                // 权重>运载能力，永远不会被运送
                return false;
            }
            if (left < weight) {
                left = k;
                D--;
            }
            left -= weight;
        }
        // >0 表示能在D天内完成
        return D > 0;
    }
}
