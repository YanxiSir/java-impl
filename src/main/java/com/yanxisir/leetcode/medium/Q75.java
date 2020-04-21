package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Tag;

/**
 * 颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 *
 * @author: YanxiSir
 * @Date: 2020/4/19
 * @Sign: 心中田间，木行水上
 */
@Tag({"快排", "荷兰国旗"})
public class Q75 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
        return solution1(nums);
    }

    // 荷兰国旗问题
    protected int[] solution1(int[] nums) {
        int p0 = 0, cur = 0, p2 = nums.length - 1, tmp;
        // =p2 跟2没关系，可能会跟0互换
        while (cur <= p2) {
            if (nums[cur] == 0) {
                tmp = nums[p0];
                nums[p0] = nums[cur];
                nums[cur] = tmp;
                p0++;
                cur++;
            } else if (nums[cur] == 2) {
                tmp = nums[cur];
                nums[cur] = nums[p2];
                nums[p2] = tmp;
                p2--;
            } else {
                cur++;
            }
        }
        return nums;
    }

    // 快排
    protected int[] solution2(int[] nums) {

        return nums;
    }
}
