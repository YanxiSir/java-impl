package com.yanxisir.leetcode;

import com.google.common.base.Joiner;
import com.yanxisir.leetcode.zmodel.TreeNode;

/**
 * leetcode题解入口
 *
 * @author: YanxiSir
 * @Date: 2020/2/4
 * @Sign: 心中田间，木行水上
 */
public class Main {

    public static void main(String[] args) throws Exception {
//        Q("409").exec("abccccdd").print();
//        Q("412").exec(15).print();
//        Q("414").exec(new int[]{3, 2, 1}).print();
//        Q("101").exec(new TreeNode(1)).print();
//        Q("236").exec(new TreeNode(1), new TreeNode(2), new TreeNode(3)).print();
        Q("102").exec(array2Tree(new Integer[]{3, 9, 20, null, null, 15, 7})).print();
    }


    private static TreeNode array2Tree(Integer[] array) {
        int len = array.length;
        if (len == 0) {
            return null;
        }
        return fill(array, 0);
    }

    private static TreeNode fill(Integer[] array, int cur) {
        int len = array.length;
        if (cur >= len || array[cur] == null) {
            return null;
        }
        TreeNode node = new TreeNode(array[cur]);
        node.left = fill(array, cur * 2 + 1);
        node.right = fill(array, cur * 2 + 2);
        return node;
    }

    private static AbstractQ Q(String id) throws Exception {
        try {
            return getSimpleQ(id);
        } catch (Exception e) {
            try {
                return getMediumQ(id);
            } catch (Exception e1) {
                return getHardQ(id);
            }
        }
    }

    private static AbstractQ baseQ(String packagePath, String id) throws Exception {
        String className = Joiner.on("").join(packagePath, "Q", id);
        Class c = Class.forName(className);
        return (AbstractQ) c.newInstance();
    }

    private static AbstractQ getSimpleQ(String id) throws Exception {
        return baseQ("com.yanxisir.leetcode.simple.", id);
    }

    private static AbstractQ getMediumQ(String id) throws Exception {
        return baseQ("com.yanxisir.leetcode.medium.", id);
    }

    private static AbstractQ getHardQ(String id) throws Exception {
        return baseQ("com.yanxisir.leetcode.hard.", id);
    }
}
