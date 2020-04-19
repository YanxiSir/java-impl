package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Remember;
import com.yanxisir.leetcode.zannos.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 只出现一次的数字 III
 * https://leetcode-cn.com/problems/single-number-iii/
 *
 * @author: YanxiSir
 * @Date: 2020/4/18
 * @Sign: 心中田间，木行水上
 */
@Tag({"位运算"})
@Remember
public class Q260 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
        return solution1(nums);
    }

    // 遍历一遍，空间复杂度 O(n)
    protected int[] solution1(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                map.put(n, 1);
                continue;
            }
            map.put(n, map.get(n) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        return new int[]{list.get(0), list.get(1)};
    }

    // 解法很优秀
    // [2,1,2,3,4,1]
    // 遍历一遍，空间复杂度 O(1)
    protected int[] solution2(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) {
            return res;
        }
        int xorRes = 0;
        for (int x : nums) {
            xorRes ^= x;
        }
        int temp = 1; // 用来标志第几位是 1
        while (true) {
            if ((xorRes & 1) == 1) {
                break;
            }
            temp = temp << 1;
            xorRes = xorRes >> 1; // 右移，从低到高
        }

        for (int y : nums) {
            // 两个单独数据分组。每组内相同value 异或后会抵消掉
            if ((y & temp) == 0) { // 对应位是 0
                res[0] ^= y;
            } else {
                res[1] ^= y;
            }
        }
        return res;
    }
}
