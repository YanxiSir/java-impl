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
        AbstractQ iq = getQ("409");
        iq.run();
    }


    private static AbstractQ getQ(String id) throws Exception {
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
