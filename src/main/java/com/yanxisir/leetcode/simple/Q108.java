package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Remember;
import com.yanxisir.leetcode.zannos.Tag;
import com.yanxisir.leetcode.zmodel.TreeNode;

/**
 * 将有序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * @author: YanxiSir
 * @Date: 2020/2/18
 * @Sign: 心中田间，木行水上
 */
@Tag({"DFS"})
@Remember
public class Q108 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        int[] nums = (int[]) args[0];
        return solution1(nums);
    }

    // 始终选择中间位置左边节点为根节点
    private TreeNode solution1(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return handle(nums, 0, nums.length - 1);
    }

    private TreeNode handle(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = handle(nums, l, mid - 1);
        node.right = handle(nums, mid + 1, r);
        return node;
    }
}
