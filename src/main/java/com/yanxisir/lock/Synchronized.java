package com.yanxisir.lock;

/**
 * @author: YanxiSir
 * @Date: 2019/10/11
 * @Sign: 心中田间，木行水上
 */
public class Synchronized {

    private Integer ss = 2;
    private String ss_s = "Yanxi";

    public synchronized void test() {
        String tmp = "tmp";
        System.out.println("hello world");
    }
}

class C1 {

}

class C2 {

}