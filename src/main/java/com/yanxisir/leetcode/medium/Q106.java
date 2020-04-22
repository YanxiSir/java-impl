package com.yanxisir.leetcode.medium;

import com.google.common.collect.Lists;
import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Tag;
import com.yanxisir.leetcode.zmodel.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * @author: YanxiSir
 * @Date: 2020/4/19
 * @Sign: 心中田间，木行水上
 */
@Tag("二叉树遍历")
public class Q106 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int[] inorder = (int[]) args[0];
        int[] postorder = (int[]) args[1];
        return solution1(inorder, postorder);
    }

    int post_pos = 0;

    protected TreeNode solution1(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        post_pos = postorder.length - 1;
        return helper1(inorder, postorder, inOrderMap, 0, inorder.length);
    }


    protected TreeNode helper1(int[] inorder, int[] postorder, Map<Integer, Integer> inOrderMap, int in_l, int in_r) {
        if (in_l == in_r) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[post_pos]);
        int index = inOrderMap.get(root.val);
        post_pos--;
        root.right = helper1(inorder, postorder, inOrderMap, index + 1, in_r);
        root.left = helper1(inorder, postorder, inOrderMap, in_l, index);

        return root;
    }

    @Override
    protected List<Class> related() {
        return Lists.newArrayList(Q105.class, Q889.class);
    }
}
