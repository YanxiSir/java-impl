package com.yanxisir.leetcode;

import com.google.common.base.Joiner;

/**
 * leetcode题解入口
 *
 * @author: YanxiSir
 * @Date: 2020/2/4
 * @Sign: 心中田间，木行水上
 */
public class Main {

    public static void main(String[] args) throws Exception {
        IQ iq = getQ("409");
        iq.run();
    }

    private static IQ getQ(String id) throws Exception {
        String className = Joiner.on("").join("com.yanxisir.leetcode.", "Q", id);
        Class c = Class.forName(className);
        return (IQ) c.newInstance();
    }
}
