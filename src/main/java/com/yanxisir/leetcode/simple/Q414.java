package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 第三大的数
 * https://leetcode-cn.com/problems/third-maximum-number/
 *
 * @author: YanxiSir
 * @Date: 2020/2/10
 * @Sign: 心中田间，木行水上
 */
public class Q414 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
//        return solution1(nums);
//        return solution2(nums);
        return solution3(nums);
    }

    protected Object solution1(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).mapToObj(o -> o).collect(Collectors.toSet());
        if (set.size() <= 2) {
            return set.stream().mapToInt(o -> o).max().getAsInt();
        }
        for (int i = 0; i < 2; i++) {
            int max = set.stream().mapToInt(o -> o).max().getAsInt();
            set.remove(max);
        }
        return set.stream().mapToInt(o -> o).max().getAsInt();
    }

    protected Object solution2(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).mapToObj(o -> o).collect(Collectors.toSet());
        if (set.size() <= 2) {
            return set.stream().mapToInt(o -> o).max().getAsInt();
        }
        // 第一大，第二大，第三大
        int oneMax = Integer.MIN_VALUE;
        int twoMax = Integer.MIN_VALUE;
        int threeMax = Integer.MIN_VALUE;
        for (Integer i : set) {
            if (i > oneMax) {
                threeMax = twoMax;
                twoMax = oneMax;
                oneMax = i;
                continue;
            }
            if (i > twoMax) {
                threeMax = twoMax;
                twoMax = i;
                continue;
            }
            if (i > threeMax) {
                threeMax = i;
            }
        }
        return threeMax;
    }

    protected Object solution3(int[] nums) {

        // 第一大，第二大，第三大
        long oneMax = Long.MIN_VALUE;
        long twoMax = Long.MIN_VALUE;
        long threeMax = Long.MIN_VALUE;
        for (Integer i : nums) {
            if (i == oneMax || i == twoMax || i == threeMax) {
                continue;
            }
            if (i > oneMax) {
                threeMax = twoMax;
                twoMax = oneMax;
                oneMax = i;
                continue;
            }
            if (i > twoMax) {
                threeMax = twoMax;
                twoMax = i;
                continue;
            }
            if (i > threeMax) {
                threeMax = i;
            }
        }
        if (threeMax == Long.MIN_VALUE) {
            return (int) oneMax;
        }
        return (int) threeMax;
    }
}
