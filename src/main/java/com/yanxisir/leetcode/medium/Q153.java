package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Tag;
import com.yanxisir.leetcode.zannos.Tree;

/**
 * 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * @author: YanxiSir
 * @Date: 2020/2/23
 * @Sign: 心中田间，木行水上
 */
@Tag({"二分"})
public class Q153 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
        return solution2(nums);
    }

    // 二分查找-递归
    protected int solution1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        if (l + 1 == r) {
            return Math.min(nums[l], nums[r]);
        }
        int mid = (r - l) / 2 + l;
        if (nums[mid] > nums[mid + 1]) {
            return nums[mid + 1];
        }
        if (nums[mid] < nums[mid - 1]) {
            return nums[mid];
        }
        return Math.min(search(nums, l, mid), search(nums, mid + 1, r));
    }

    // 二分-非递归
    protected int solution2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int l = 0, r = nums.length - 1;
        if (nums[r] > nums[0]) {
            return nums[0];
        }
        while (l <= r) {
            if (l == r) {
                return nums[l];
            }
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
