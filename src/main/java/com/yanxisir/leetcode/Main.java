package com.yanxisir.leetcode;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.yanxisir.leetcode.zmodel.ListNode;
import com.yanxisir.leetcode.zmodel.TreeNode;
import io.swagger.models.auth.In;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

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
//        Q("102").exec(array2Tree(new Integer[]{3, 9, 20, null, null, 15, 7})).print();
//        Q("104").exec(array2Tree(new Integer[]{3, 9, 20, null, null, 15, 7})).print();
//        Q("107").exec(array2Tree(new Integer[]{3, 9, 20, null, null, 15, 7})).print();
//        Q("108").exec(new int[]{-10, -3, 0, 5, 9}).print();
//        Q("109").exec(array2Linked(new Integer[]{-10, -3, 0, 5, 9})).print();
//        Q("110").exec(array2Tree(new Integer[]{3, 9, 20, null, null, 15, 7})).print();
//        Q("617").exec(array2Tree(new Integer[]{1, 3, 2, 5}), array2Tree(new Integer[]{2, 1, 3, null, 4, null, 7})).print();
//        Q("94").exec(array2Tree(new Integer[]{1, null, 2, 3})).print();
//        Q("166").exec(-1, 1).print();
//        Q("543").exec(array2Tree(new Integer[]{3, 9, 20, null, null, 15, 7})).print();
//        Q("19").exec(array2Linked(new Integer[]{1, 2}), 2).print();
//        Q("53").exec(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}).print();
//        Q("70").exec(6).print();
//        Q("234").exec(array2Linked(new Integer[]{1, 2, 2,2,1})).print();
//        Q("198").exec(new int[]{2, 1, 1, 2}).print();
//        Q("121").exec(new int[]{2, 1, 1, 2}).print();
//        Q("445").exec(array2Linked(new Integer[]{1}), array2Linked(new Integer[]{9,9})).print();
//        Q("62").exec(7, 3).print();
//        Q("63").exec(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}).print();
//        Q("120").exec(Lists.newArrayList(Lists.newArrayList(2), Lists.newArrayList(3, 4), Lists.newArrayList(6, 5, 7), Lists.newArrayList(4, 1, 8, 3))).print();
//        Q("144").exec(array2Tree(new Integer[]{1, null, 2, 3})).print();
//        Q("152").exec(new int[]{-2, 0, -1}).print();
//        Q("153").exec(new int[]{1, 2}).print();
//        Q("213").exec(new int[]{2, 1, 1, 2}).print();
//        Q("260").exec(new int[]{2, 1, 2, 3, 4, 1}).print();
//        Q("377").exec(new int[]{1, 2, 3}, 4).print();
//        Q("39").exec(new int[]{2, 3, 6, 7}, 7).print();
//        Q("40").exec(new int[]{10, 1, 2, 7, 6, 1, 5}, 8).print();
//        Q("77").exec(4, 2).print();
//        Q("216").exec(3, 9).print();
//        Q("112").exec(array2Tree(new Integer[]{1, 2}), 1).print();
//        Q("17").exec("23").print();
//        Q("257").exec(array2Tree(new Integer[]{1, 2, 3})).print();
//        Q("3").exec("pwwkew").print();
//        Q("5").exec("abcdz").print();
//        Q("912").exec(new int[]{5, 2, 3, 1}).print();
//        Q("54").exec(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}).print();
        Q("2").exec(array2Linked(new Integer[]{9, 9, 9, 9, 9, 9, 9}), array2Linked(new Integer[]{9, 9, 9, 9})).print();


    }


    private static ListNode array2Linked(Integer[] array) {
        int len = array.length;
        if (len == 0) {
            return null;
        }
        ListNode root = new ListNode(array[0]);
        ListNode cur = root;
        for (int i = 1; i < len; i++) {
            ListNode node = new ListNode(array[i]);
            cur.next = node;
            cur = node;
        }
        return root;
    }

    private static Integer[] linked2Array(ListNode node) {
        List<Integer> result = Lists.newArrayList();
        while (node != null) {
            result.add(node.val);
            node = node.next;
        }
        return result.stream().toArray(value -> new Integer[0]);
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
