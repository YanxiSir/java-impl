package com.yanxisir.leetcode.hard;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Remember;
import com.yanxisir.leetcode.zannos.Tag;

import java.util.Arrays;

/**
 * 数组中的逆序对
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 *
 * @author: YanxiSir
 * @date: 2020/5/8
 * @sign: help yourself
 */
@Tag("归并排序")
@Remember
public class QMS51 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
        return solution1(nums);
    }

    // 暴力 : 超时
    protected int solution1(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int cc = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i < j && nums[i] > nums[j]) {
                    cc++;
                }
            }
        }
        return cc;
    }


    // 归并
    protected int solution2(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }
        int[] copy = Arrays.copyOf(nums, len);
        int[] temp = new int[len];
        return cal2(copy, 0, len - 1, temp);
    }

    // 计算逆序对个数 & 排序
    private int cal2(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPairs = cal2(nums, left, mid, temp);
        int rightPairs = cal2(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }
        int crossPairs = sort2(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    // nums[left..mid] 有序，nums[mid + 1..right] 有序
    private int sort2(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k >= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }

}
