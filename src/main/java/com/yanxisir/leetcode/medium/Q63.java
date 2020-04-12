package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.DynamicPrograming;
import com.yanxisir.leetcode.zannos.Remember;

/**
 * 不同路径II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 *
 * @author: YanxiSir
 * @Date: 2020/2/21
 * @Sign: 心中田间，木行水上
 */
@Remember
@DynamicPrograming
public class Q63 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int[][] obstacleGrid = (int[][]) args[0];
        return solution1(obstacleGrid);
    }

    protected int solution1(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < row; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 1 || dp[i - 1][0] == 0) ? 0 : 1;
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = (obstacleGrid[0][i] == 1 || dp[0][i - 1] == 0) ? 0 : 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : (dp[i - 1][j] + dp[i][j - 1]);
            }
        }
        return dp[row - 1][col - 1];
    }
}
