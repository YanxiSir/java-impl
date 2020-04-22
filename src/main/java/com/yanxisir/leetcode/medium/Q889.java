package com.yanxisir.leetcode.medium;

import com.google.common.collect.Lists;
import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Tag;
import com.yanxisir.leetcode.zmodel.TreeNode;

import java.util.List;

/**
 * 根据前序和后序遍历构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 *
 * @author: YanxiSir
 * @Date: 2020/2/21
 * @Sign: 心中田间，木行水上
 */
@Tag("二叉树遍历")
public class Q889 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        int[] pre = (int[]) args[0];
        int[] post = (int[]) args[1];
        return solution1(pre, post);
    }

    protected TreeNode solution1(int[] pre, int[] post) {
        if (pre.length == 0 || post.length == 0) {
            return null;
        }
        return helper(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }

    protected TreeNode helper(int[] pre, int[] post, int pre_l, int pre_r, int post_l, int post_r) {
        if (pre_l > pre_r) {
            return null;
        }
        TreeNode root = new TreeNode(pre[pre_l++]);
        // 找到后续的改点
        for (int i = post_l; i < post_r; i++) {
            if (post[i] == pre[pre_l]) {
                int length = i - post_l + 1;
                root.left = helper(pre, post, pre_l, pre_l + length - 1, post_l, i);
                root.right = helper(pre, post, pre_l + length, pre_r, i + 1, post_r - 1);
            }
        }
        return root;
    }

    @Override
    protected List<Class> related() {
        return Lists.newArrayList(Q106.class, Q105.class);
    }
}
