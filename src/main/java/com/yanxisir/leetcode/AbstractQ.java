package com.yanxisir.leetcode;

/**
 * @author: YanxiSir
 * @Date: 2020/2/4
 * @Sign: 心中田间，木行水上
 */
public abstract class AbstractQ {


    public AbstractQ() {
        System.out.println("<========= i'm leetcode " + this.getClass().getSimpleName() + " ==========>");
    }

    protected abstract void run();
}
