package com.yanxisir;

public class SimpleZigzag {

    public static void main(String[] args) {
//        System.out.println(cal(2));
//        System.out.println(cal(-2));
        t();
    }

    public static int cal(int n) {
        System.out.println("=========" + n + "========");
        System.out.println("n<<1 : " + (n << 1));
        System.out.println("n>>1 : " + (n >> 31));
        // 左移-补0；右移-补1
        return (n << 1) ^ (n >> 31);
    }

    public static void t() {

    }
}
