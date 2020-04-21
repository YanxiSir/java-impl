package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Tag;

/**
 * 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author: YanxiSir
 * @Date: 2020/4/21
 * @Sign: 心中田间，木行水上
 */
@Tag("双指针")
public class Q11 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int[] height = (int[]) args[0];
        return solution1(height);
    }

    // 两次遍历
    protected int solution1(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }

    // 双指针
    protected int solution2(int[] height) {
        int l = 0, h = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (l < h) {
            max = Math.max(max, (h - l) * Math.min(height[l], height[h]));
            if (height[l] < height[h]) {
                l++;
            } else {
                h--;
            }
        }
        return max;
    }
}
