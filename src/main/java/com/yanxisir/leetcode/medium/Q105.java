package com.yanxisir.leetcode.medium;

import com.google.common.collect.Lists;
import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Tag;
import com.yanxisir.leetcode.zmodel.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author: YanxiSir
 * @Date: 2020/4/19
 * @Sign: 心中田间，木行水上
 */
@Tag("二叉树遍历")
public class Q105 extends AbstractQ {
    @Override
    protected Object run(Object... args) {
        int[] preorder = (int[]) args[0];
        int[] inorder = (int[]) args[1];
        return solution1(preorder, inorder);
    }

    int pre_post = 0;

    protected TreeNode solution1(int[] preorder, int[] inorder) {
        // 中序记录index
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return helper1(preorder, inorder, inOrderMap, 0, inorder.length);
    }

    private TreeNode helper1(int[] preorder, int[] inorder, Map<Integer, Integer> inOrderMap, int in_l, int in_r) {
        if (in_l == in_r) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre_post]);
        int index = inOrderMap.get(root.val);
        pre_post++;
        root.left = helper1(preorder, inorder, inOrderMap, in_l, index);
        root.right = helper1(preorder, inorder, inOrderMap, index + 1, in_r);
        return root;
    }

    @Override
    protected List<Class> related() {
        return Lists.newArrayList(Q106.class, Q889.class);
    }
}
