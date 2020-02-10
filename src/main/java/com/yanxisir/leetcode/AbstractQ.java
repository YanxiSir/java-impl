package com.yanxisir.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @author: YanxiSir
 * @Date: 2020/2/4
 * @Sign: 心中田间，木行水上
 */
public abstract class AbstractQ {

    protected Object result;

    public AbstractQ() {
        System.out.println("<========= i'm leetcode " + this.getClass().getSimpleName() + " ==========>");
    }

    /**
     * @param args 请求入参
     */
    protected abstract Object run(Object... args);

    protected AbstractQ exec(Object... args) {
        this.result = run(args);
        return this;
    }

    protected void print() {
        System.out.println("result:" + JSON.toJSONString(this.result));
        System.out.println("<-------------- end " + this.getClass().getSimpleName() + " -------------->");
    }

}
