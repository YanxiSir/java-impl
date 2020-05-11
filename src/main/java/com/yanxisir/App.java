package com.yanxisir;

import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 */
public class App {
    public static void main1(String[] args) {
        System.out.println("Hello World!");
    }


    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int m = 3, n = 3;
        int[][] nums = new int[][]{
//                {0, 1, 0, 0, 0, 0},
//                {0, 1, 1, 0, 1, 0},
//                {0, 0, 0, 0, 1, 0},
//                {0, 1, 1, 1, 1, 0},
//                {0, 1, 0, 0, 0, 0},
//                {0, 1, 0, 0, 0, 0}
                {0, 1, 0},
                {0, 0, 1},
                {1, 0, 0}
        };
        int[][] memo = new int[6][6];
        Set<Integer> memoSet = new HashSet<>();
        memoSet.add(0);
        int right = move(nums, m, n, 0, 1, 1, memoSet);
        int bottom = move(nums, m, n, 1, 0, 1, memoSet);
        int ret = -1;
        if (right > 0 && bottom > 0) {
            ret = Math.min(right, bottom);
        } else if (right > 0) {
            ret = right;
        } else if (bottom > 0) {
            ret = bottom;
        } else {
            ret = 0;
        }
        System.out.println(ret);
    }

    private static int move(int[][] nums, int m, int n, int pos_i, int pos_j, int max, Set<Integer> memoSet) {
        if (pos_i == m - 1 && pos_j == n - 1) {
            return max;
        }
        int min = Integer.MAX_VALUE;
        // 节点满足
        if (pos_i >= 0 && pos_i <= m && pos_j >= 0 && pos_j <= n) {
            if (nums[pos_i][pos_j] == 1) {
                return -1;
            }
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;
            int top = Integer.MAX_VALUE;
            int bottom = Integer.MAX_VALUE;
            int next_i = -1, next_j = -1;
            next_i = pos_i - 1;
            next_j = pos_j;
            Integer val = calVal(next_i, next_j);
            if (isRight(next_i, m, next_j, n) && !memoSet.contains(val)) {
                memoSet.add(val);
                left = move(nums, m, n, next_i, next_j, max + 1, memoSet);
                memoSet.remove(val);
            }
            next_i = pos_i;
            next_j = pos_j - 1;
            val = calVal(next_i, next_j);
            if (isRight(next_i, m, next_j, n) && !memoSet.contains(val)) {
                memoSet.add(val);
                top = move(nums, m, n, next_i, next_j, max + 1, memoSet);
                memoSet.remove(val);
            }
            next_i = pos_i;
            next_j = pos_j + 1;
            val = calVal(next_i, next_j);
            if (isRight(next_i, m, next_j, n) && !memoSet.contains(val)) {
                memoSet.add(val);
                bottom = move(nums, m, n, next_i, next_j, max + 1, memoSet);
                memoSet.remove(val);
            }
            next_i = pos_i + 1;
            next_j = pos_j;
            val = calVal(next_i, next_j);
            if (isRight(next_i, m, next_j, n) && !memoSet.contains(val)) {
                memoSet.add(val);
                right = move(nums, m, n, next_i, next_j, max + 1, memoSet);
                memoSet.remove(val);
            }
            if (left > 0 && left < Integer.MAX_VALUE) {
                min = Math.min(min, left);
            }
            if (right > 0 && left < Integer.MAX_VALUE) {
                min = Math.min(min, right);
            }
            if (top > 0 && left < Integer.MAX_VALUE) {
                min = Math.min(min, top);
            }
            if (bottom > 0 && left < Integer.MAX_VALUE) {
                min = Math.min(min, bottom);
            }
        }
        return min;
    }

    private static boolean isRight(int pos_i, int m, int pos_j, int n) {
        return pos_i >= 0 && pos_i <= m - 1 && pos_j >= 0 && pos_j <= n - 1;
    }

    private static Integer calVal(int m, int n) {
        return m * 10 + n;
    }
}
