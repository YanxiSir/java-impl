package com.yanxisir.gc;

/**
 * @author: YanxiSir
 * @Date: 2019/11/19
 * @Sign: 心中田间，木行水上
 */
public class GcTest {

    public static void main(String[] args) {
        if (true) {
            byte[] placeHolder = new byte[64 * 1024 * 1024];
            System.out.println(placeHolder.length / 1024);
        }
//        int place = 1;
        System.gc();
    }
}
