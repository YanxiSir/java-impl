package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Remember;

/**
 * 删除排序数组中的重复项 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * @author: YanxiSir
 * @Date: 2020/4/18
 * @Sign: 心中田间，木行水上
 */
@Remember
public class Q80 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
        return solution1(nums);
    }

    // 1,1,1,2,2,3  -> 1,1,2,2,3
    // 思路1：记录当前字段和出现次数。一旦变换 开始调整后面的元素迁移
    protected int solution1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int curLen = 1;
        int pos = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                curLen++;
            } else {
                curLen = 1;
            }

            if (curLen <= 2) {
                // 这一步很关键！！！
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }
}
