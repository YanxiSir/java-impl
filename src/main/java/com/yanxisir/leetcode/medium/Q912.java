package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;

/**
 * 排序数组
 * https://leetcode-cn.com/problems/sort-an-array/
 *
 * @author: YanxiSir
 * @date: 2020/5/8
 * @sign: help yourself
 */
public class Q912 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
        return solution2(nums);
    }

    // 归并
    protected int[] solution1(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        sort1(nums, 0, nums.length - 1);
        return nums;
    }

    protected void sort1(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort1(nums, l, mid);
        sort1(nums, mid + 1, r);

        int[] tmp = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int pos = 0;
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                tmp[pos++] = nums[i++];
            } else {
                tmp[pos++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[pos++] = nums[i++];
        }
        while (j <= r) {
            tmp[pos++] = nums[j++];
        }
        for (int k = 0; k < r - l + 1; k++) {
            nums[l + k] = tmp[k];
        }
    }

    // 快排
    protected int[] solution2(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        sort2(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort2(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int pos = findZero(nums, l, r);
        sort2(nums, l, pos - 1);
        sort2(nums, pos + 1, r);
    }

    private int findZero(int[] num, int l, int r) {
        if (l == r) {
            return l;
        }
        int tag = num[l];
        int pl = l, pr = r;
        boolean vsRight = true;
        while (pl < pr) {
            if (vsRight) {
                if (tag < num[pr]) {
                    pr--;
                } else {
                    num[pl++] = num[pr];
                    vsRight = false;
                }
            } else {
                if (tag > num[pl]) {
                    pl++;
                } else {
                    num[pr--] = num[pl];
                    vsRight = true;
                }
            }
        }
        num[pl] = tag;
        return pl;
    }

    // 桶排序
    protected int[] solution3(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        sort2(nums, 0, nums.length - 1);
        return nums;
    }
}
