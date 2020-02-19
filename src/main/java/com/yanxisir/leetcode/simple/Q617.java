package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Tree;
import com.yanxisir.leetcode.zmodel.TreeNode;

import java.util.Stack;

/**
 * 合并二叉树
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * @author: YanxiSir
 * @Date: 2020/2/19
 * @Sign: 心中田间，木行水上
 */
public class Q617 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        TreeNode t1 = (TreeNode) args[0];
        TreeNode t2 = (TreeNode) args[1];
//        return solution1(t1, t2);
        return solution2(t1, t2);
    }

    // 递归
    private TreeNode solution1(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        t1.val += t2.val;
        t1.left = solution1(t1.left, t2.left);
        t1.right = solution1(t1.right, t2.right);
        return t1;
    }

    // 迭代,最后返回t1
    private TreeNode solution2(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});
        while (!stack.empty()) {
            TreeNode[] tn = stack.pop();
            if (tn[0] == null || tn[1] == null) {
                // 此处用|| 是因为  =======a====== 处已经将存在的节点置换到t1对应的节点下了
                continue;
            }
            tn[0].val += tn[1].val;
            // 先处理左边节点
            if (tn[0].left == null) {
                //  =======a======
                tn[0].left = tn[1].left;
            } else {
                stack.push(new TreeNode[]{tn[0].left, tn[1].left});
            }
            // 再处理右边
            if (tn[0].right == null) {
                //  =======a======
                tn[0].right = tn[1].right;
            } else {
                stack.push(new TreeNode[]{tn[0].right, tn[1].right});
            }
        }
        return t1;
    }
}
