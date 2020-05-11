package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * https://leetcode-cn.com/problems/spiral-matrix/
 *
 * @author: YanxiSir
 * @date: 2020/5/11
 * @sign: help yourself
 */
public class Q54 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
//        int[][] matrix = (int[][]) args[0];
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        return solution1(matrix);
    }

    public List<Integer> solution1(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int row = matrix.length, col = matrix[0].length;
        int size = row * col;
        int row_l = 0, row_r = row - 1, col_l = 0, col_r = col - 1;
        while (list.size() < size) {

//            if (row_l == row_r && col_l == col_r) {
//                list.add(matrix[row_l][col_l]);
//                break;
//            }
            // 上边
            for (int i = col_l; i <= col_r && list.size() < size; i++) {
                list.add(matrix[row_l][i]);
            }
            if (row_l < row_r) {
                row_l++;
            }
            // 右边
            for (int i = row_l; i <= row_r && list.size() < size; i++) {
                list.add(matrix[i][col_r]);
            }
            if (col_r > col_l) {
                col_r--;
            }
            // 下面
            for (int i = col_r; i >= col_l && list.size() < size; i--) {
                list.add(matrix[row_r][i]);
            }
            if (row_r > row_l) {
                row_r--;
            }
            // 左边
            for (int i = row_r; i >= row_l && list.size() < size; i--) {
                list.add(matrix[i][col_l]);
            }
            if (col_l < col_r) {
                col_l++;
            }
        }
        return list;
    }
}
