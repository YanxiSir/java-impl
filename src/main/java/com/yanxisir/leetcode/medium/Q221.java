package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.DynamicPrograming;
import com.yanxisir.leetcode.zannos.Remember;
import com.yanxisir.leetcode.zannos.Tag;

/**
 * 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 *
 * @author: YanxiSir
 * @Date: 2020/2/21
 * @Sign: 心中田间，木行水上
 */
@Remember
@Tag({"正方形动态规划"})
@DynamicPrograming
public class Q221 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        char[][] matrix = (char[][]) args[0];
        return solution1(matrix);
    }

    // 暴力, 有问题
    protected int solution1(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int ret = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; i < col; j++) {
                if (matrix[i][j] != 1) {
                    continue;
                }
                ret = Math.max(ret, 1);
                int rleft = row - i - 1;
                int lleft = col - j - 1;
                int step = Math.min(rleft, lleft);
                for (int m = 1; m <= step; m++) {
                    // 行都是1,列=j+m
                    boolean haveZero = false;
                    for (int t = i + 1; t <= i + m; t++) {
                        if (matrix[t][j + m] != 1) {
                            haveZero = true;
                            break;
                        }
                    }
                    // 列都是1,行=i+m
                    for (int t = j + 1; t <= j + m; t++) {
                        if (matrix[i + m][t] != 1) {
                            haveZero = true;
                            break;
                        }
                    }
                    if (haveZero) {
                        break;
                    } else {
                        ret = Math.max(m + 1, ret);
                    }
                }
            }
        }
        return ret * ret;
    }

    // 动态规划
    protected int solution2(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row + 1][col + 1];
        int max = 0;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    // 动态规划 - 空间优化
    protected int solution3(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] dp = new int[col + 1];
        int max = 0;
        int pre = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                int tmp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), pre) + 1;
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                pre = tmp;
            }
        }
        return max * max;
    }
}
